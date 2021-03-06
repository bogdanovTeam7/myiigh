package hu.ak_akademia.myiigh.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;
import hu.ak_akademia.myiigh.util.constants.Constants;
import hu.ak_akademia.myiigh.util.exceptions.IIGHRuntimeException;

public abstract class ModifierAbstractDao implements ModifierDataBaseDao {
	protected SQLBuilder sqlBuilder;
	protected PreparedStatementWriter preparedStatementWriter;
	protected String errorMassege = "Hiba az adatbázis új sor beszúrásákor.";

	public ModifierAbstractDao(SQLBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter) {
		this.sqlBuilder = sqlBuilder;
		this.preparedStatementWriter = preparedStatementWriter;
	}

	public void create() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection(Constants.getUrl(), Constants.getUser(),
				Constants.getPassword())) {
			String sql = sqlBuilder.build();
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatementWriter.write(preparedStatement);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new IIGHRuntimeException(errorMassege, e);
		}
	}

	public void update() {
		errorMassege = "Hiba az adatbázis meglevő sor modosításákor.";
		create();
	}

}

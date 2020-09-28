package hu.ak_akademia.myiigh.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.myiigh.Constants;
import hu.ak_akademia.myiigh.IIGHRuntimeException;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public abstract class ModifierAbstractDao implements ModifierDataBaseDao {
	protected SQLBuilder sqlBuilder;
	protected PreparedStatementWriter preparedStatementWriter;
	protected String errorMassege = "Hiba az adatbázis új sor beszúrásákor.";

	public ModifierAbstractDao(SQLBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter) {
		this.sqlBuilder = sqlBuilder;
		this.preparedStatementWriter = preparedStatementWriter;
	}

	public void create() {
		try (Connection connection = DriverManager.getConnection(Constants.getUrl(), Constants.getUser(),
				Constants.getPassword())) {
			String sql = sqlBuilder.build();
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				if (preparedStatementWriter != null) {
					preparedStatementWriter.write(preparedStatement);
				}
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

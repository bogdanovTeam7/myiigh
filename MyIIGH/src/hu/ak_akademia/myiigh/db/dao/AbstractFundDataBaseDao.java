package hu.ak_akademia.myiigh.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import hu.ak_akademia.myiigh.Constants;
import hu.ak_akademia.myiigh.IIGHRuntimeException;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public abstract class AbstractFundDataBaseDao<P> implements ModifierDataBaseDao {
	protected SQLBuilder sqlBuilder;
	protected PreparedStatementWriter<P> preparedStatementWriter;
	protected String errorMassege = "Error during record insertion into database.";

	public AbstractFundDataBaseDao(SQLBuilder sqlBuilder) {
		this.sqlBuilder = sqlBuilder;
	}

	public AbstractFundDataBaseDao(SQLBuilder sqlBuilder, PreparedStatementWriter<P> preparedStatementWriter) {
		this.sqlBuilder = sqlBuilder;
		this.preparedStatementWriter = preparedStatementWriter;
	}

	public void create() {
		try (Connection connection = DriverManager.getConnection(Constants.getUrl(), Constants.getUser(),
				Constants.getUrl())) {
			String sql = sqlBuilder.build();
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				if (preparedStatementWriter != null) {
					preparedStatementWriter.write(preparedStatement);
				}
				preparedStatement.executeUpdate();
			}
		} catch (Exception e) {
			throw new IIGHRuntimeException(errorMassege, e);
		}
	}

	public void update() {
		errorMassege = "Error during record update in database.";
		create();
//		errorMassege = "Error during record insertion into database.";
	}

}

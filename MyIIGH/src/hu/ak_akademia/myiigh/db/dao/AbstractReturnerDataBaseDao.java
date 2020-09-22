package hu.ak_akademia.myiigh.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.myiigh.Constants;
import hu.ak_akademia.myiigh.IIGHRuntimeException;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public abstract class AbstractReturnerDataBaseDao<P, R> extends AbstractFundDataBaseDao<P>
		implements ReturnerDataBaseDao<R> {
	protected ResultSetReader<R> resultSetReader;

	{
		errorMassege = "Error during query from database.";
	}

	public AbstractReturnerDataBaseDao(SQLBuilder sqlBuilder, ResultSetReader<R> resultSetReader) {
		super(sqlBuilder);
		this.resultSetReader = resultSetReader;
	}

	public AbstractReturnerDataBaseDao(SQLBuilder sqlBuilder, PreparedStatementWriter<P> preparedStatementWriter,
			ResultSetReader<R> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter);
		this.resultSetReader = resultSetReader;
	}

	public List<R> retrieve() {
		try (Connection connection = DriverManager.getConnection(Constants.getUrl(), Constants.getUser(),
				Constants.getPassword())) {
			String sql = sqlBuilder.build();
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				if (preparedStatementWriter != null) {
					preparedStatementWriter.write(preparedStatement);
				}
				ResultSet resSet = preparedStatement.executeQuery();
				return resultSetReader.retrieve(resSet);
			}
		} catch (SQLException e) {
			throw new IIGHRuntimeException(errorMassege, e);
		}
	}

}

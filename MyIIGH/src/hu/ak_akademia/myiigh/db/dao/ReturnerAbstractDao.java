package hu.ak_akademia.myiigh.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;
import hu.ak_akademia.myiigh.util.constants.Constants;

public class ReturnerAbstractDao<R> extends ModifierAbstractDao implements ReturnerDataBaseDao<R> {
	private ResultSetReader<R> resultSetReader;

	public ReturnerAbstractDao(SQLBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter,
			ResultSetReader<R> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter);
		this.resultSetReader = resultSetReader;
	}

	public List<R> retrieve() {
		List<R> result = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(Constants.getUrl(), Constants.getUser(),
				Constants.getPassword())) {
			String sql = sqlBuilder.build();
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				if (preparedStatementWriter != null) {
					preparedStatementWriter.write(preparedStatement);
				}
				ResultSet resultSet = preparedStatement.executeQuery();
				result = resultSetReader.retrieve(resultSet);
			}
		} catch (SQLException e) {
			errorMassege = "Hiba az adatbázisból lekérdezéskor.";
		}
		return result;

	}

}

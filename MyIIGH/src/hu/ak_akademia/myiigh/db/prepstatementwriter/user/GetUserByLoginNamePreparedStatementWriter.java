package hu.ak_akademia.myiigh.db.prepstatementwriter.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;

public class GetUserByLoginNamePreparedStatementWriter implements PreparedStatementWriter {

	private String loginName;

	public GetUserByLoginNamePreparedStatementWriter(String loginName) {
		this.loginName = loginName;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, loginName);
	}

}

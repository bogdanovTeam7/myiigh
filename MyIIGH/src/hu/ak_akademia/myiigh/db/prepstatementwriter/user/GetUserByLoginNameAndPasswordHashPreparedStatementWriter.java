package hu.ak_akademia.myiigh.db.prepstatementwriter.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;

public class GetUserByLoginNameAndPasswordHashPreparedStatementWriter implements PreparedStatementWriter {

	private String loginName;
	private String passwordHash;

	public GetUserByLoginNameAndPasswordHashPreparedStatementWriter(String loginName, String passwordHash) {
		this.loginName = loginName;
		this.passwordHash = passwordHash;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, loginName);
		preparedStatement.setString(2, passwordHash);
	}

}

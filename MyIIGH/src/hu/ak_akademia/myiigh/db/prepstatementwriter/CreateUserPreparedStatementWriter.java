package hu.ak_akademia.myiigh.db.prepstatementwriter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.myiigh.db.entity.User;

public class CreateUserPreparedStatementWriter implements PreparedStatementWriter {

	private User user;

	public CreateUserPreparedStatementWriter(User user) {
		this.user = user;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, user.getLoginName());
		preparedStatement.setString(i++, user.getPasswordHash());
		preparedStatement.setString(i++, user.getFirstName());
		preparedStatement.setString(i++, user.getLastName());
		preparedStatement.setLong(i++, user.getRoleId());
		preparedStatement.setString(i++, user.getPostalAddress());
		preparedStatement.setString(i++, user.getPhone());
		preparedStatement.setString(i++, user.getEmail());
		preparedStatement.setString(i++, Boolean.TRUE.equals(user.getNewsletter()) ? "Y" : "N");
		preparedStatement.setDate(i++, Date.valueOf(user.getDateOfBirth()));
		preparedStatement.setLong(i++, user.getUserStatusId());
	}

}

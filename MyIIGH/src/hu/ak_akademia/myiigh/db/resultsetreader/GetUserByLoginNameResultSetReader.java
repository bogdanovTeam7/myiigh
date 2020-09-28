package hu.ak_akademia.myiigh.db.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.myiigh.db.entity.User;
import hu.ak_akademia.myiigh.util.PasswordManager;

public class GetUserByLoginNameResultSetReader implements ResultSetReader<User> {

	@Override
	public List<User> retrieve(ResultSet resultSet) throws SQLException {
		List<User> users = new ArrayList<>();
		while (resultSet.next()) {
			String loginName = resultSet.getString("login_name");
			String passwordHash = new PasswordManager().encrypt(resultSet.getString("password"));
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			Long roleId = resultSet.getLong("role_id");
			String postalAddress = resultSet.getString("postal_address");
			String phone = resultSet.getString("phone");
			String email = resultSet.getString("email");
			Boolean newsletter = ("Y".equals(resultSet.getString("newsletter")) ? Boolean.TRUE : Boolean.FALSE);
			LocalDate dateOfBirth = null;
			if (resultSet.getDate("date_of_birth") != null) {
				dateOfBirth = resultSet.getDate("date_of_birth")
						.toLocalDate();
			}
			LocalDateTime lastLoginDate = null;
			if (resultSet.getTimestamp("last_login_date") != null) {
				lastLoginDate = resultSet.getTimestamp("last_login_date")
						.toLocalDateTime();
			}
			Long userStatusId = resultSet.getLong("user_status_id");
			User user = User.builder()
					.withLoginName(loginName)
					.withPasswordHash(passwordHash)
					.withFirstName(firstName)
					.withLastName(lastName)
					.withRoleId(roleId)
					.withPostalAddress(postalAddress)
					.withPhone(phone)
					.withEmail(email)
					.withNewsletter(newsletter)
					.withDateOfBirth(dateOfBirth)
					.withLastLoginDate(lastLoginDate)
					.withUserStatusId(userStatusId)
					.build();
			users.add(user);
		}
		return users;
	}

}

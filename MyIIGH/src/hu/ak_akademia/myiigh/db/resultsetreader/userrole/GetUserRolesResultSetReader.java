package hu.ak_akademia.myiigh.db.resultsetreader.userrole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.myiigh.db.entity.Role;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;

public class GetUserRolesResultSetReader implements ResultSetReader<Role> {

	@Override
	public List<Role> retrieve(ResultSet resultSet) throws SQLException {
		List<Role> userRoles = new ArrayList<>();
		while (resultSet.next()) {
			Long roleId = resultSet.getLong("role_id");
			String name = resultSet.getString("role_name");
			String displayName = resultSet.getString("role_display_name");
			Role role = Role.builder()
					.withRoleId(roleId)
					.withName(name)
					.withDisplayName(displayName)
					.build();
			userRoles.add(role);
		}
		return userRoles;
	}

}

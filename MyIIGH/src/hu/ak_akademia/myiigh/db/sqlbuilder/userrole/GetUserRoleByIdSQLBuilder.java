package hu.ak_akademia.myiigh.db.sqlbuilder.userrole;

import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class GetUserRoleByIdSQLBuilder implements SQLBuilder {

	@Override
	public String build() {
		return "SELECT * FROM roles WHERE role_id = ?";
	}

}

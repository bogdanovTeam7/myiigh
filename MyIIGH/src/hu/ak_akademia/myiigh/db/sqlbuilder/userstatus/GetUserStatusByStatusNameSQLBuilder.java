package hu.ak_akademia.myiigh.db.sqlbuilder.userstatus;

import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class GetUserStatusByStatusNameSQLBuilder implements SQLBuilder {

	@Override
	public String build() {
		return "SELECT * FROM user_status WHERE status_name = ?";
	}

}

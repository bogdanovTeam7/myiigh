package hu.ak_akademia.myiigh.db.sqlbuilder.userstatus;

import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class GetUserStatusByStatusIdSQLBuilder implements SQLBuilder {

	@Override
	public String build() {
		return "SELECT * FROM user_status WHERE user_status_id = ?";
	}

}

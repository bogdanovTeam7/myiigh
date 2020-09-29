package hu.ak_akademia.myiigh.db.sqlbuilder.user;

import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class GetUserByLoginNameSQLBuilder implements SQLBuilder {

	@Override
	public String build() {
		return "SELECT * FROM users WHERE login_name = ?";
	}

}

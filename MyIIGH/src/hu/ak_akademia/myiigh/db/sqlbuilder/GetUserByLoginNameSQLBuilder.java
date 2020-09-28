package hu.ak_akademia.myiigh.db.sqlbuilder;

public class GetUserByLoginNameSQLBuilder implements SQLBuilder {

	@Override
	public String build() {
		return "SELECT * FROM users WHERE login_name = ?";
	}

}

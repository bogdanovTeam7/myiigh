package hu.ak_akademia.myiigh.db.dao;

import hu.ak_akademia.myiigh.db.entity.User;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class UserFundDao extends AbstractFundDataBaseDao<User> {

	
	public UserFundDao(SQLBuilder sqlBuilder) {
		super(sqlBuilder);
	}

	public UserFundDao(SQLBuilder sqlBuilder, PreparedStatementWriter<User> preparedStatementWriter) {
		super(sqlBuilder, preparedStatementWriter);
	}

}

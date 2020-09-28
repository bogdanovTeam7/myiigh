package hu.ak_akademia.myiigh.db.dao;

import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class CreateUserDao extends ModifierAbstractDao{

	public CreateUserDao(SQLBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter) {
		super(sqlBuilder, preparedStatementWriter);
	}

}

package hu.ak_akademia.myiigh.db.dao.user;

import hu.ak_akademia.myiigh.db.dao.ModifierAbstractDao;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class ModifierUserDao extends ModifierAbstractDao {

	public ModifierUserDao(SQLBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter) {
		super(sqlBuilder, preparedStatementWriter);
	}

}

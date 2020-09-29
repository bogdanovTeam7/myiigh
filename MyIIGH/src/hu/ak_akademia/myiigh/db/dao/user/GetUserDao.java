package hu.ak_akademia.myiigh.db.dao.user;

import hu.ak_akademia.myiigh.db.dao.ReturnerAbstractDao;
import hu.ak_akademia.myiigh.db.entity.User;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class GetUserDao extends ReturnerAbstractDao<User> {

	public GetUserDao(SQLBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter,
			ResultSetReader<User> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}

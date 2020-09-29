package hu.ak_akademia.myiigh.db.dao.userstatus;

import hu.ak_akademia.myiigh.db.dao.ReturnerAbstractDao;
import hu.ak_akademia.myiigh.db.entity.UserStatus;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class GetUserStatusDao extends ReturnerAbstractDao<UserStatus> {

	public GetUserStatusDao(SQLBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter,
			ResultSetReader<UserStatus> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}

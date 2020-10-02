package hu.ak_akademia.myiigh.db.dao.role;

import hu.ak_akademia.myiigh.db.dao.ReturnerAbstractDao;
import hu.ak_akademia.myiigh.db.entity.Role;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;

public class GetUserRolesDao extends ReturnerAbstractDao<Role> {

	public GetUserRolesDao(SQLBuilder sqlBuilder, PreparedStatementWriter preparedStatementWriter,
			ResultSetReader<Role> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}

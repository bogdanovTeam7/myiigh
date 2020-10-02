package hu.ak_akademia.myiigh.util.validation;

import hu.ak_akademia.myiigh.db.dao.role.GetUserRolesDao;
import hu.ak_akademia.myiigh.db.entity.Role;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.prepstatementwriter.userrole.GetUserRoleByIdPreparedStatementWriter;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.myiigh.db.resultsetreader.userrole.GetUserRolesResultSetReader;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;
import hu.ak_akademia.myiigh.db.sqlbuilder.userrole.GetUserRoleByIdSQLBuilder;

public class UserRoleValidator implements Validator<Long> {

	@Override
	public boolean test(Long toTest) {
		SQLBuilder sqlBuilder = new GetUserRoleByIdSQLBuilder();
		PreparedStatementWriter preparedStatementWriter = new GetUserRoleByIdPreparedStatementWriter(toTest);
		ResultSetReader<Role> resultSetReader = new GetUserRolesResultSetReader();
		GetUserRolesDao userRolesDao = new GetUserRolesDao(sqlBuilder, preparedStatementWriter, resultSetReader);
		return userRolesDao.retrieve()
				.size() > 0;

	}

}

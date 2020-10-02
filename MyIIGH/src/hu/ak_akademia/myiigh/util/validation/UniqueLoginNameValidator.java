package hu.ak_akademia.myiigh.util.validation;

import java.util.List;

import hu.ak_akademia.myiigh.db.dao.user.GetUserDao;
import hu.ak_akademia.myiigh.db.entity.User;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.prepstatementwriter.user.GetUserByLoginNamePreparedStatementWriter;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.myiigh.db.resultsetreader.user.GetUsersResultSetReader;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;
import hu.ak_akademia.myiigh.db.sqlbuilder.user.GetUserByLoginNameSQLBuilder;

public class UniqueLoginNameValidator implements Validator<String> {

	public UniqueLoginNameValidator() {
	}

	@Override
	public boolean test(String loginName) {
		SQLBuilder sqlBuilder = new GetUserByLoginNameSQLBuilder();
		PreparedStatementWriter preparedStatementWriter = new GetUserByLoginNamePreparedStatementWriter(loginName);
		ResultSetReader<User> resultSetReader = new GetUsersResultSetReader();
		GetUserDao getUserDao = new GetUserDao(sqlBuilder, preparedStatementWriter, resultSetReader);
		List<User> result = getUserDao.retrieve();
		return result.size() < 1;
	}

}

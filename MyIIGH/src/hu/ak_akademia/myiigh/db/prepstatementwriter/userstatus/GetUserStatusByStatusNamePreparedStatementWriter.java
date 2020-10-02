package hu.ak_akademia.myiigh.db.prepstatementwriter.userstatus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;

public class GetUserStatusByStatusNamePreparedStatementWriter implements PreparedStatementWriter {

	private String statusName;

	public GetUserStatusByStatusNamePreparedStatementWriter(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, statusName);
	}

}

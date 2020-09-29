package hu.ak_akademia.myiigh.db.prepstatementwriter.userstatus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;

public class GetUserStatusByIdPreparedStatementWriter implements PreparedStatementWriter {

	private long id;

	public GetUserStatusByIdPreparedStatementWriter(long id) {
		this.id = id;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, id);

	}

}

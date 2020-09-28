package hu.ak_akademia.myiigh.db.prepstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementWriter {

	void write(PreparedStatement preparedStatement) throws SQLException;
}

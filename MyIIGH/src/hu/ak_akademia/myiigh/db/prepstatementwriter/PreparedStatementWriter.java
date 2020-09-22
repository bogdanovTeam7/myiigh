package hu.ak_akademia.myiigh.db.prepstatementwriter;

import java.sql.PreparedStatement;

public interface PreparedStatementWriter<P> {

	void write(PreparedStatement preparedStatement);
}

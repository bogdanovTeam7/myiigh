package hu.ak_akademia.myiigh.db.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetReader<R> {
	List<R> retrieve(ResultSet resultSet) throws SQLException;
}

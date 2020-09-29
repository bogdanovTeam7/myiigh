package hu.ak_akademia.myiigh.db.resultsetreader.userstatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.myiigh.db.entity.UserStatus;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;

public class GetUserStatusesResultSetReader implements ResultSetReader<UserStatus> {

	@Override
	public List<UserStatus> retrieve(ResultSet resultSet) throws SQLException {
		List<UserStatus> userStatuses = new ArrayList<>();
		while (resultSet.next()) {
			Long userStatuId = resultSet.getLong("user_status_id");
			String statusName = resultSet.getString("status_name");
			String statusDisplayName = resultSet.getString("status_display_name");
			UserStatus userStatus = UserStatus.builder()
					.withUserStatuId(userStatuId)
					.withName(statusName)
					.withDisplayName(statusDisplayName)
					.build();
			userStatuses.add(userStatus);
		}
		return userStatuses;
	}

}

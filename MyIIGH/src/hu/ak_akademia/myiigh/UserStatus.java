package hu.ak_akademia.myiigh;

public enum UserStatus {
	PENDING(1),
	ACTIVE(2),
	INACTIVE(3);

	private final long userStatuId;

	private UserStatus(long userStatuId) {
		this.userStatuId = userStatuId;
	}

	public long getUserStatuId() {
		return userStatuId;
	}

	public UserStatus getUserStatusById(long userStatuId) {

		for (UserStatus userStatus : values()) {
			if (userStatus.getUserStatuId() == userStatuId) {
				return userStatus;
			}
		}
		throw new IllegalArgumentException("Unexpected value of user status identifier: " + userStatuId);
	}
}

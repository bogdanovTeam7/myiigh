package hu.ak_akademia.myiigh.db.entity;

public class UserStatus {

	private final long userStatuId;
	private final String name;
	private final String displayName;

	private UserStatus(Builder builder) {
		this.userStatuId = builder.userStatuId;
		this.name = builder.name;
		this.displayName = builder.displayName;
	}

	public static Builder builder() {
		return new Builder();
	}

	public long getUserStatuId() {
		return userStatuId;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static final class Builder {
		private long userStatuId;
		private String name;
		private String displayName;

		private Builder() {
		}

		public Builder withUserStatuId(long userStatuId) {
			this.userStatuId = userStatuId;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDisplayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		public UserStatus build() {
			return new UserStatus(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("UserStatus [userStatuId=");
		builder2.append(userStatuId);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append(", displayName=");
		builder2.append(displayName);
		builder2.append("]");
		return builder2.toString();
	}

}

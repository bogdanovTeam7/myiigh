package hu.ak_akademia.myiigh.db.entity;

public class Role {

	private final long roleId;
	private final String name;
	private final String displayName;

	private Role(Builder builder) {
		this.roleId = builder.roleId;
		this.name = builder.name;
		this.displayName = builder.displayName;
	}

	public static Builder builder() {
		return new Builder();
	}

	public long getRoleId() {
		return roleId;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static final class Builder {
		private long roleId;
		private String name;
		private String displayName;

		private Builder() {
		}

		public Builder withRoleId(long roleId) {
			this.roleId = roleId;
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

		public Role build() {
			return new Role(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Role [roleId=");
		builder2.append(roleId);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append(", displayName=");
		builder2.append(displayName);
		builder2.append("]");
		return builder2.toString();
	}

}

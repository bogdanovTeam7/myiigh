package hu.ak_akademia.myiigh;

public enum Role {
	ADMIN(1),
	USER(2);

	private final long roleId;

	private Role(long roleId) {
		this.roleId = roleId;
	}

	public long getRoleId() {
		return roleId;
	}

	public Role getRoleById(long roleId) {
		for (Role role : values()) {
			if (role.getRoleId() == roleId) {
				return role;
			}
		}
		throw new IllegalArgumentException("Unexpected value of role identifier: " + roleId);
	}

}

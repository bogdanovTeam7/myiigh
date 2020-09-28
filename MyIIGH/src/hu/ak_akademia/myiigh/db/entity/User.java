package hu.ak_akademia.myiigh.db.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
	private String loginName;
	private String passwordHash;
	private String firstName;
	private String lastName;
	private Long roleId;
	private String postalAddress;
	private String phone;
	private String email;
	private Boolean newsletter;
	private LocalDate dateOfBirth;
	private LocalDateTime registrationDate;
	private LocalDateTime lastLoginDate;
	private Long userStatusId;

	private User(Builder builder) {
		this.loginName = builder.loginName;
		this.passwordHash = builder.passwordHash;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.roleId = builder.roleId;
		this.postalAddress = builder.postalAddress;
		this.phone = builder.phone;
		this.email = builder.email;
		this.newsletter = builder.newsletter;
		this.dateOfBirth = builder.dateOfBirth;
		this.registrationDate = builder.registrationDate;
		this.lastLoginDate = builder.lastLoginDate;
		this.userStatusId = builder.userStatusId;
	}

	public static Builder builder() {
		return new Builder();
	}

	public String getLoginName() {
		return loginName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getNewsletter() {
		return newsletter;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public Long getUserStatusId() {
		return userStatusId;
	}

	public static final class Builder {
		private String loginName;
		private String passwordHash;
		private String firstName;
		private String lastName;
		private Long roleId;
		private String postalAddress;
		private String phone;
		private String email;
		private Boolean newsletter;
		private LocalDate dateOfBirth;
		private LocalDateTime registrationDate;
		private LocalDateTime lastLoginDate;
		private Long userStatusId;

		private Builder() {
		}

		public Builder withLoginName(String loginName) {
			this.loginName = loginName;
			return this;
		}

		public Builder withPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withRoleId(Long roleId) {
			this.roleId = roleId;
			return this;
		}

		public Builder withPostalAddress(String postalAddress) {
			this.postalAddress = postalAddress;
			return this;
		}

		public Builder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withNewsletter(Boolean newsletter) {
			this.newsletter = newsletter;
			return this;
		}

		public Builder withDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder withRegistrationDate(LocalDateTime registrationDate) {
			this.registrationDate = registrationDate;
			return this;
		}

		public Builder withLastLoginDate(LocalDateTime lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
			return this;
		}

		public Builder withUserStatusId(Long userStatusId) {
			this.userStatusId = userStatusId;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("User [loginName=");
		builder2.append(loginName);
		builder2.append(", passwordHash=");
		builder2.append(passwordHash);
		builder2.append(", firstName=");
		builder2.append(firstName);
		builder2.append(", lastName=");
		builder2.append(lastName);
		builder2.append(", roleId=");
		builder2.append(roleId);
		builder2.append(", postalAddress=");
		builder2.append(postalAddress);
		builder2.append(", phone=");
		builder2.append(phone);
		builder2.append(", email=");
		builder2.append(email);
		builder2.append(", newsletter=");
		builder2.append(newsletter);
		builder2.append(", dateOfBirth=");
		builder2.append(dateOfBirth);
		builder2.append(", registrationDate=");
		builder2.append(registrationDate);
		builder2.append(", lastLoginDate=");
		builder2.append(lastLoginDate);
		builder2.append(", userStatusId=");
		builder2.append(userStatusId);
		builder2.append("]");
		return builder2.toString();
	}

}

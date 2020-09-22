package hu.ak_akademia.myiigh.db.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import hu.ak_akademia.myiigh.Role;
import hu.ak_akademia.myiigh.UserStatus;

public class User {
	private String loginName;
	private String passwordHash;
	private String firstName;
	private String lastName;
	private Role role;
	private String postalAddress;
	private String phone;
	private String email;
	private Boolean newsletter;
	private LocalDate dateOfBirth;
	private LocalDateTime registrationDate;
	private LocalDateTime lastLoginDate;
	private UserStatus userStatus;
}

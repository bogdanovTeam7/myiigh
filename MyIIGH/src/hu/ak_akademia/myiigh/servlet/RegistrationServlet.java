package hu.ak_akademia.myiigh.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.myiigh.db.dao.user.ModifierUserDao;
import hu.ak_akademia.myiigh.db.dao.userstatus.GetUserStatusDao;
import hu.ak_akademia.myiigh.db.entity.User;
import hu.ak_akademia.myiigh.db.entity.UserStatus;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.prepstatementwriter.user.CreateUserPreparedStatementWriter;
import hu.ak_akademia.myiigh.db.prepstatementwriter.userstatus.GetUserStatusByStatusNamePreparedStatementWriter;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.myiigh.db.resultsetreader.userstatus.GetUserStatusesResultSetReader;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;
import hu.ak_akademia.myiigh.db.sqlbuilder.user.CreateUserSQLBuilder;
import hu.ak_akademia.myiigh.db.sqlbuilder.userstatus.GetUserStatusByStatusNameSQLBuilder;
import hu.ak_akademia.myiigh.util.password.PasswordManager;
import hu.ak_akademia.myiigh.util.validation.AdressValidator;
import hu.ak_akademia.myiigh.util.validation.EmailValidator;
import hu.ak_akademia.myiigh.util.validation.NameValidator;
import hu.ak_akademia.myiigh.util.validation.PasswordConfirmationValidator;
import hu.ak_akademia.myiigh.util.validation.PasswordStrengthValidator;
import hu.ak_akademia.myiigh.util.validation.PhoneValidator;
import hu.ak_akademia.myiigh.util.validation.StringLengthValidator;
import hu.ak_akademia.myiigh.util.validation.UniqueLoginNameValidator;
import hu.ak_akademia.myiigh.util.validation.UserRoleValidator;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("registration.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		String confirmationPassword = request.getParameter("confirmationPassword");
		String userRoleIdInString = request.getParameter("userRole");
		Long userRoleId = userRoleIdInString != null ? Long.parseLong(userRoleIdInString) : 0;
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String dateOfBirthInString = request.getParameter("dateOfBirth");
		LocalDate dateOfBirth = (dateOfBirthInString == null || dateOfBirthInString.length() < 1) ? null
				: LocalDate.parse(dateOfBirthInString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String newsletterInString = request.getParameter("newsletter");
		boolean newsletter = newsletterInString != null;

		Map<String, String> errors = new HashMap<String, String>();

		boolean isValid = new StringLengthValidator(8, 31).test(loginName);
		if (!isValid) {
			errors.put("loginNameError", "A felhasználónév hossza nem megfelelő");
		}

		isValid = new UniqueLoginNameValidator().test(loginName);
		if (!isValid) {
			errors.put("loginNameError", "Ez a felhasználónév már foglalt");
		}

		isValid = new UserRoleValidator().test(userRoleId);
		if (!isValid) {
			errors.put("userRoleIdError", "Érvénytelen szerepkör");

		}

		isValid = new StringLengthValidator(8, 31).test(password);
		if (!isValid) {
			errors.put("passwordError", "A jelszó hossza nem megfelelő");
		}

		isValid = new PasswordStrengthValidator().test(password);
		if (!isValid) {
			errors.put("passwordError", "A jelszó formatuma nem megfelelő");
		}

		isValid = new PasswordConfirmationValidator(password).test(confirmationPassword);
		if (!isValid) {
			errors.put("passwordError", "A jelszó ismétlése nem egyezz az eredetivel");
		}

		isValid = new NameValidator().test(firstName);
		if (!isValid) {
			errors.put("firstNameError", "A keresztnév hossza nem megfelelő");
		}

		isValid = new NameValidator().test(lastName);
		if (!isValid) {
			errors.put("lastNameError", "A vezetéknév hossza nem megfelelő");
		}

		isValid = new AdressValidator().test(address);
		if (!isValid) {
			errors.put("addressError", "Érvénytelen cím");
		}

		isValid = new EmailValidator().test(email);
		if (!isValid) {
			errors.put("emailError", "Érvénytelen email cím");
		}

		isValid = new PhoneValidator(10, 20).test(phone);
		if (!isValid) {
			errors.put("phoneError", "A telefonszám nem érvényes");
		}

		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("registration.jsp")
					.forward(request, response);
		} else {
			String passwordHash = new PasswordManager().encrypt(password);

			SQLBuilder sqlBuilder = new GetUserStatusByStatusNameSQLBuilder();
			PreparedStatementWriter preparedStatementWriter = new GetUserStatusByStatusNamePreparedStatementWriter(
					"pending");
			ResultSetReader<UserStatus> resultSetReader = new GetUserStatusesResultSetReader();
			GetUserStatusDao userStatusDao = new GetUserStatusDao(sqlBuilder, preparedStatementWriter, resultSetReader);
			Long userStatusId = userStatusDao.retrieve()
					.get(0)
					.getUserStatuId();

			User user = User.builder()
					.withLoginName(loginName)
					.withPasswordHash(passwordHash)
					.withFirstName(firstName)
					.withLastName(lastName)
					.withRoleId(userRoleId)
					.withPostalAddress(address)
					.withPhone(phone)
					.withEmail(email)
					.withDateOfBirth(dateOfBirth)
					.withNewsletter(newsletter)
					.withUserStatusId(userStatusId)
					.build();

			sqlBuilder = new CreateUserSQLBuilder();
			preparedStatementWriter = new CreateUserPreparedStatementWriter(user);
			ModifierUserDao userDao = new ModifierUserDao(sqlBuilder, preparedStatementWriter);
			userDao.create();

			request.setAttribute("successfulRegistration", Boolean.TRUE);
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}

	}

}

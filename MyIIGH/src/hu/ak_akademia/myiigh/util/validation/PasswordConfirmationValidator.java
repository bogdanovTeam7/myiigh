package hu.ak_akademia.myiigh.util.validation;

public class PasswordConfirmationValidator implements Validator<String> {
	private final String password;

	public PasswordConfirmationValidator(String password) {
		this.password = password;
	}

	@Override
	public boolean test(String toTest) {
		if (password == null) {
			return false;
		}
		return password.equals(toTest);
	}

}

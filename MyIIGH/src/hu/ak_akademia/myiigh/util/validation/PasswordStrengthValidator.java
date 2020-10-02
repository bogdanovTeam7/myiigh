package hu.ak_akademia.myiigh.util.validation;

public class PasswordStrengthValidator implements Validator<String> {
	private final int minLength = 8;
	private final int minOfUpperLetters = 1;
	private final int minOfLowerLetters = 1;
	private final int minCountOfDigits = 1;

	public PasswordStrengthValidator() {
	}

	@Override
	public boolean test(String toTest) {
		if (toTest == null) {
			return false;
		}
		toTest = toTest.trim();
		if (toTest.length() < minLength) {
			return false;
		}
		if (toTest.chars()
				.filter(c -> (c >= 'A' && c <= 'Z'))
				.count() < minOfUpperLetters) {
			return false;
		}
		if (toTest.chars()
				.filter(c -> (c >= 'a' && c <= 'z'))
				.count() < minOfLowerLetters) {
			return false;
		}
		if (toTest.chars()
				.filter(c -> (c >= '0' && c <= '9'))
				.count() < minCountOfDigits) {
			return false;
		}
		return true;
	}

}

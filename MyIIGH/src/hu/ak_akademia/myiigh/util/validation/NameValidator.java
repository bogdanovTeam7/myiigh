package hu.ak_akademia.myiigh.util.validation;

public class NameValidator implements Validator<String> {
	private int minLength = 2;
	private int maxLength = 30;

	@Override
	public boolean test(String toTest) {
		return toTest.length() >= minLength && toTest.length() <= maxLength;
	}

}

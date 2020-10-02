package hu.ak_akademia.myiigh.util.validation;

/**
 * @param minLength is inclusive
 * @param maxLength is exclusive
 */
public class StringLengthValidator implements Validator<String> {
	private final int minLength;
	private final int maxLength;

	public StringLengthValidator(int minLength, int maxLength) {
		this.minLength = minLength;
		this.maxLength = maxLength;
	}

	@Override
	public boolean test(String toTest) {
		if (toTest == null || toTest.trim()
				.length() < 1) {
			return false;
		}
		return toTest.trim()
				.length() >= minLength
				&& toTest.trim()
						.length() < maxLength;
	}

}

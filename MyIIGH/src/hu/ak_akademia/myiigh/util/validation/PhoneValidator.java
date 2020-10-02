package hu.ak_akademia.myiigh.util.validation;

/**
 * @param minPhoneLength inclusive
 * @param maxPhoneLength exclusive
 */

public class PhoneValidator implements Validator<String> {

	private final int minPhoneLength;
	private final int maxPhoneLength;
	private final String separators = "+()/ -";

	public PhoneValidator(int minCountOfNumbers, int maxCountOfNumbers) {
		this.minPhoneLength = minCountOfNumbers;
		this.maxPhoneLength = maxCountOfNumbers;
	}

	@Override
	public boolean test(String toTest) {
		if (toTest == null) {
			return false;
		}
		int phoneLength = 0;
		for (int i = 0; i < toTest.length(); i++) {
			char c = toTest.charAt(i);
			if (c >= '0' && c <= '9') {
				phoneLength++;
			} else if (!separators.contains("" + c)) {
				return false;
			}
		}
		if (phoneLength >= minPhoneLength && phoneLength < maxPhoneLength) {
			return true;
		}
		return false;
	}

}

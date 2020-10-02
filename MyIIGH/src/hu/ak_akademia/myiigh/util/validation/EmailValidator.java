package hu.ak_akademia.myiigh.util.validation;

public class EmailValidator implements Validator<String> {
	private String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

	@Override
	public boolean test(String toTest) {
		return toTest.matches(regex);
	}

}

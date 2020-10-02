package hu.ak_akademia.myiigh.util.validation;

public class AdressValidator implements Validator<String> {

	@Override
	public boolean test(String toTest) {
		return toTest.length() >= 5 && toTest.length() <= 100;
	}

}

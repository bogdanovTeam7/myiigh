package hu.ak_akademia.myiigh.util.validation;

public interface Validator<E> {
	boolean test(E toTest);
}

package hu.ak_akademia.myiigh;

public class Constants {
	private static final String URL = "jdbc:postgresql://localhost:5432/iigh";
	private static final String USER = "myiigh";
	private static final String PASSWORD = "admin";

	public static String getUrl() {
		return URL;
	}

	public static String getUser() {
		return USER;
	}

	public static String getPassword() {
		return PASSWORD;
	}

}

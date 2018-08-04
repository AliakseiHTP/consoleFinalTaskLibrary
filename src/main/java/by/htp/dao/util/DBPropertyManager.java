package by.htp.dao.util;

import java.util.ResourceBundle;

public class DBPropertyManager {
	private static final ResourceBundle rb;

	static {
		rb = ResourceBundle.getBundle("db_config");
	}

	public static String getProperty(String propertyName) {
		return rb.getString(propertyName);
	}

	public static String getDBURL() {
		return rb.getString("db.url");
	}

	public static String getLogin() {
		return rb.getString("db.login");
	}

	public static String getPassword() {
		return rb.getString("db.password");
	}
}

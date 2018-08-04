package by.htp.capabilities;

import by.htp.dao.database.LoginDataBaseImpl;
import by.htp.entity.Person;

public class Login {
	private static final String ERROR_MESSAGE = "Wrong data! Please check your login and password.";
	private static final String WELCOME_MESSAGE = "Welcome";

	public Person authorization(String login, String password) {
		LoginDataBaseImpl authorizationDao = new LoginDataBaseImpl();
		Person person = authorizationDao.getAutorizatePerson(login, password);
		if(person!=null) {
			sendMessage(WELCOME_MESSAGE);
			return person;
		}
		sendMessage(ERROR_MESSAGE);
		return person;
	}

	private void sendMessage(String message) {
		System.out.println(message);
	}
}

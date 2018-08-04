package by.htp.interfaceP;

import by.htp.entity.Person;

public interface ILogin {
	
	public Person getAutorizatePerson(String login, String password);
}

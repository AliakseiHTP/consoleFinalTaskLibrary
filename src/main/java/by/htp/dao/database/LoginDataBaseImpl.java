package by.htp.dao.database;

import java.sql.ResultSet;

import by.htp.dao.abstractP.DBConnection;
import by.htp.dao.interfaceP.ILogin;
import by.htp.entity.Person;

public class LoginDataBaseImpl extends DBConnection implements ILogin {
	private static final String SELECT_LOGIN = "SELECT* FROM loginpasstable JOIN librarycard "
			+ "ON loginpasstable.id_librarycard = librarycard.id_librarycard WHERE login=? AND password=?";

	public Person getAutorizatePerson(String login, String password) {
		openConnection();
		getPreparedStatement(SELECT_LOGIN);
		setString(1, login);
		setString(2, password);
		executeQuery();
		Person person = buildPerson(getResultSet());
		closeAll();
		return person;
	}

	private Person buildPerson(ResultSet result) {
		Person person = null;
		if (resNext()) {
			person = new Person();
			person.setIdlibrarycard(getInt("id_librarycard"));
			person.setAccessLevel(getInt("accessLevel"));
			person.setName(getString("owner_name"));
			person.setSurname(getString("owner_surname"));
			person.setPhoneNumber(getString("owner_phone_number"));
			return person;
		}
		return person;
	}
}

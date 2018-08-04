package by.htp.capabilities;

import java.util.List;

import by.htp.dao.database.BookDao;
import by.htp.dao.database.LoginDataBaseImpl;
import by.htp.entity.Book;
import by.htp.entity.Person;

public class Functionality {
	private static BookDao bookDao = new BookDao();
	private static final String ERROR_MESSAGE = "Wrong data! Please check your login and password.";
	private static final String WELCOME_MESSAGE = "Welcome";

	public static Person authorization(String login, String password) {
		LoginDataBaseImpl loginDao = new LoginDataBaseImpl();
		Person person = loginDao.getAutorizatePerson(login, password);
		if (person != null) {
			sendMessage(WELCOME_MESSAGE);
			return person;
		}
		sendMessage(ERROR_MESSAGE);
		return person;
	}

	private static void sendMessage(String message) {
		System.out.println(message);
	}

	public static Book getElementById(int idElem, Person person) {
		Book book = null;
		if (person.getAccessLevel() >= 1) {
			book = bookDao.getElementById(idElem);
		}
		return book;
	}

	private static String getListBook() {
		String strTmp = "";
		List<Book> listBook = bookDao.getListElement();
		for (Book book : listBook) {
			strTmp +=book.getId()+ " "+ book.getBookName() + " " + book.getStatus() + "\n";
		}
		return strTmp;
	}

	public static void printListBook(Person person) {
		if (person.getAccessLevel() >= 1) {
			System.out.println(getListBook());
		}

	}

	private static String getBook(int idElem) {
		String strTmp = "";
		Book book = bookDao.getElementById(idElem);
		strTmp = book.toString();
		return strTmp;
	}

	public static void printBook(int idElem, Person person) {
		if (person.getAccessLevel() >= 1) {
			System.out.println(getBook(idElem));
		}
	}
}

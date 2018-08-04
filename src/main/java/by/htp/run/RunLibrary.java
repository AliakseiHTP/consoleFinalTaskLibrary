package by.htp.run;

import by.htp.dao.database.BookDao;
import by.htp.entity.Author;
import by.htp.entity.Book;
import by.htp.entity.Person;
import by.htp.ui.MenuAuthorization;

public class RunLibrary {

	public static void main(String[] args) {
		MenuAuthorization menuAuthorization = new MenuAuthorization();
		menuAuthorization.showMenu();
		BookDao book = new BookDao();
		book.addBook(buildBook());

	}

	public static Person buildPerson() {
		Person person = new Person();
		person.setAccessLevel(2);
		person.setName("Aliaksei");
		person.setSurname("Kazak");
		person.setPhoneNumber("6644925");
		return person;
	}

	public static Book buildBook() {
		Book book = new Book();
		book.setBookName("The best book in the world");
		book.setAuthor(buildAuthor());
		return book;

	}

	public static Author buildAuthor() {
		Author author = new Author();
		author.setName("Ivan");
		author.setSurName("Ivanovich");
		author.setBirthDay(1900, 01, 01);
		return author;
	}
}

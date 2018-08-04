package by.htp.dao.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import by.htp.dao.abstractP.DBConnection;
import by.htp.dao.interfaceP.IBook;
import by.htp.entity.Author;
import by.htp.entity.Book;


public class BookDao extends DBConnection implements IBook {
	private static final String LIST_BOOK = "SELECT* FROM librarybook JOIN author ON author_book = id_author ";
	private static final String GETBOOK = "SELECT* FROM librarybook JOIN author ON author_book = id_author WHERE librarybook.id_book = ?";
	private static final String ADD_BOOK = "INSERT into library.librarybook(name_book,author_book)VALUES (?, ?)";
	private static final String FIND_AUTHOR = "SELECT* FROM author WHERE name_author=? AND surname_author=?";
	private Author author;
	private Book book;

	public List<Book> getListElement() {
		List<Book> listBook = new ArrayList<>();
		openConnection();
		getPreparedStatement(LIST_BOOK);
		executeQuery();
		while (resNext()) {
			listBook.add(buildBook(getResultSet()));
		}
		closeAll();
		return listBook;
	}

	private Book buildBook(ResultSet result) {
		book = new Book();
		author = new Author();
		book.setId(getInt("id_book"));
		book.setBookName(getString("name_book"));
		book.setStatus(getString("status_book"));
		author.setId(getInt("id_author"));
		author.setName(getString("name_author"));
		author.setSurName(getString("surname_author"));
		author.setBirthDay(getDate("birthday_author"));
		book.setAuthor(author);
		return book;
	}

	public Book getElementById(int id) {
		Book book = null;
		openConnection();
		getPreparedStatement(GETBOOK);
		setInt(1, id);
		executeQuery();
		if (resNext()) {
			book = buildBook(getResultSet());
			closeAll();
			return book;
		}
		closeAll();
		return book;
	}

	public boolean addBook(Book book) {
		Author author = book.getAuthor();
		openConnection();
		if (findAuthor(author)) {
			author.setId(getInt("id_author"));
			getPreparedStatement(ADD_BOOK);
			setString(1, book.getBookName());
			setInt(2, author.getId());
			execute();
		}
		return true;
	}

	public boolean findAuthor(Author author) {
		String expected = author.getName() + " " + author.getSurName();
		String str = "";
		openConnection();
		getPreparedStatement(FIND_AUTHOR);
		setString(1, author.getName());
		setString(2, author.getSurName());
		executeQuery();
		if (resNext()) {
			str = getString("name_author") + " " + getString("surname_author");
		}
		if (expected.equals(str)) {
			return true;
		} else {
			return false;
		}
	}
}

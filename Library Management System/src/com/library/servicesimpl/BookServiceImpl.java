package com.library.servicesimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.database.DatabaseConnection;
import com.library.database.DatabaseConnectionImpl;
import com.library.entities.Book;
import com.library.services.BookService;

public class BookServiceImpl implements BookService {

	DatabaseConnection doConnect = new DatabaseConnectionImpl();

	@Override
	public boolean addBook(Book book) {
		Statement statement = doConnect.doConnection();

		String sql = " INSERT INTO `books` (`bookName`, `author`, `publishedYear`, `publisher`,`quantity`) VALUES ('"
				+ book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublishedYear() + "', '"
				+ book.getPublisher() + "','" + book.getQuantity() + "');";

		try {
			// user added to the database
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public List<Book> getAllBooks() {
		Statement statement = doConnect.doConnection();

		List<Book> bookList = new ArrayList<>();

		String sql = "SELECT * FROM books";

		try {

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Book book = new Book();

				book.setId(rs.getInt("id"));
				book.setAuthor(rs.getString("author"));
				book.setBookName(rs.getString("bookName"));
				book.setPublishedYear(rs.getString("publishedYear"));
				book.setPublisher(rs.getString("publisher"));
				book.setQuantity(rs.getInt("quantity"));

				bookList.add(book);
			}
			return bookList;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookById(Book book) {
		Statement statement = doConnect.doConnection();

		String query = "SELECT * FROM `books` where id ='" + book.getId() + "';";

		Book editBook = new Book();

		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				editBook.setId(rs.getInt("id"));
				editBook.setId(rs.getInt("id"));
				editBook.setAuthor(rs.getString("author"));
				editBook.setBookName(rs.getString("bookName"));
				editBook.setPublishedYear(rs.getString("publishedYear"));
				editBook.setPublisher(rs.getString("publisher"));
				editBook.setQuantity(rs.getInt("quantity"));
			}
			return editBook;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateBook(Book book) {
		Statement statement = doConnect.doConnection();

		String query = "UPDATE `books` SET `id` = '" + book.getId() + "', `bookName` = '" + book.getBookName()
				+ "', `author` = '" + book.getId() + "', `publishedYear` = '" + book.getPublishedYear()
				+ "', `quantity` = '" + book.getQuantity() + "', `publisher` = '" + book.getPublisher() + "' WHERE id='"
				+ book.getId() + "';";

		try {

			statement.execute(query);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteBook(Book book) {
		Statement statement = doConnect.doConnection();

		String query = " DELETE from `books` where `id` = '" + book.getId() + "';";

		try {

			statement.execute(query);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isBookAvailable(Book book) {

		return false;
	}
}

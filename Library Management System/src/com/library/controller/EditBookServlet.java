package com.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.entities.Book;
import com.library.services.BookService;
import com.library.servicesimpl.BookServiceImpl;

public class EditBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ServletContext context;
	RequestDispatcher dispatch;

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	// the way of handling both doPost() and doGet() is similar.
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Book book = new Book();

		BookService bookService = new BookServiceImpl();

		int ID = Integer.parseInt(request.getParameter("id"));
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String publishedYear = request.getParameter("publishedYear");
		String publisher = request.getParameter("publisher");
		int quantity = Integer.parseInt(request.getParameter("quantity"));


		book.setId(ID);
		book.setAuthor(author);
		book.setBookName(bookName);
		book.setPublishedYear(publishedYear);
		book.setPublisher(publisher);
		book.setQuantity(quantity);

		boolean isbookUpdated = bookService.updateBook(book);

		if (isbookUpdated) {

			List<Book> bookList = bookService.getAllBooks();

			request.setAttribute("bookList", bookList);

			dispatch = context.getRequestDispatcher("/view/books.jsp");


		} 
		else {
			book = bookService.getBookById(book);

			request.setAttribute("book", book);

			dispatch = context.getRequestDispatcher("/view/books.jsp");
		}
		dispatch.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

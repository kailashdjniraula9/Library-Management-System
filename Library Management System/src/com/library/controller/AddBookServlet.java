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

public class AddBookServlet extends HttpServlet {


	private static final long serialVersionUID = 2512930028614908881L;
	ServletContext context;
	RequestDispatcher dispatch;

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	// the way of handling both doPost() and doGet() is similar.
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String author = request.getParameter("author");
		String bookName = request.getParameter("bookName");
		String publishedYear = request.getParameter("publishedYear");
		String publisher = request.getParameter("publisher");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

				Book book = new Book();
				book.setAuthor(author);
				book.setBookName(bookName);
				book.setPublishedYear(publishedYear);
				book.setPublisher(publisher);
				book.setQuantity(quantity);
				
				BookService bookService = new BookServiceImpl();
				
				boolean isBookAdded = bookService.addBook(book);

				if (isBookAdded) {
					
					List<Book> bkList = bookService.getAllBooks();
					
					request.setAttribute("bookList",bkList);
					
					dispatch = context.getRequestDispatcher("/view/books.jsp");
				
				}
				else {
					dispatch = context.getRequestDispatcher("/home.jsp");
				}
				
		dispatch.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

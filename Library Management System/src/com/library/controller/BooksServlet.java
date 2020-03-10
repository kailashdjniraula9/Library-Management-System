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

public class BooksServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ServletContext context;
	RequestDispatcher dispatch;

	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		BookService bookService = new BookServiceImpl();

		List<Book> bookList = bookService.getAllBooks();

		request.setAttribute("bookList", bookList);
		
		dispatch = context.getRequestDispatcher("/view/books.jsp");
		dispatch.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

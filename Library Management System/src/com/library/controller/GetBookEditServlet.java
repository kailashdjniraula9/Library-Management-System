package com.library.controller;

import java.io.IOException;

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

public class GetBookEditServlet extends HttpServlet {

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

		int id = Integer.parseInt(request.getParameter("id"));
		
		Book book = new Book();
        
		book.setId(id);
        
		BookService bookService = new BookServiceImpl();
       
		
	   
		Book bookByIdList = bookService.getBookById(book);
      
		request.setAttribute("bookByIdList", bookByIdList);
		

		dispatch = context.getRequestDispatcher("/view/editBook.jsp");

		dispatch.forward(request, response);

}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
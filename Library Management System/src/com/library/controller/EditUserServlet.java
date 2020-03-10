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

import com.library.entities.User;
import com.library.services.UserService;
import com.library.servicesimpl.UserServiceImpl;

public class EditUserServlet extends HttpServlet {

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

		User user = new User();

		UserService userService = new UserServiceImpl();

		int ID = Integer.parseInt(request.getParameter("id"));
		String fullName = request.getParameter("fullName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int role = Integer.parseInt(request.getParameter("role"));

		user.setId(ID);
		user.setFullName(fullName);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);

		boolean isUserUpdated = userService.updateUser(user);

		if (isUserUpdated) {

			List<User> userList = userService.getAllUsers();

			request.setAttribute("userList", userList);

			dispatch = context.getRequestDispatcher("/view/users.jsp");

			System.out.println("User updated \n dispatching to --- from EditUserServlet ? ");

		} 
		else {
			user = userService.getUserById(user);

			request.setAttribute("user", user);

			dispatch = context.getRequestDispatcher("/view/users.jsp");
		}
		dispatch.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

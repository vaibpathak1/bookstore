package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

/**
 * @author vaibhav
 */
public class UserServices {
	private EntityManager entityManager;
	private UserDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager=entityManager;
		userDAO = new UserDAO(entityManager);
	}

	public void listUser(String message) throws ServletException, IOException {
		List<Users> listUsers = userDAO.listAll();
		System.err.println("listUsers " + listUsers.size());
		request.setAttribute("listUsers", listUsers);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String adminPage = "users_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(adminPage);
		dispatcher.forward(request, response);
	}

	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public void createUser() throws ServletException, IOException {
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("fullname"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		Users findByEmail = userDAO.findByEmail(email);
		if (findByEmail != null) {
			String message = "Could not create user" + email + "already exists";
			request.setAttribute(message, "message");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
			Users users = new Users(email, fullName, password);
			userDAO.create(users);
			listUser("user created sucessfully now");
		}
	}

	public void editUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Users users = userDAO.get(userId);
		String destPage = "user_form.jsp";
		if (users == null) {
			destPage = "message.jsp";
			String errorMessage = "Could not find user with ID " + userId;
			request.setAttribute("message", errorMessage);
		} else {
			request.setAttribute("users", users);
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destPage);
		requestDispatcher.forward(request, response);

		/*
		 * int userId = Integer.parseInt(request.getParameter("id")); Users users =
		 * userDAO.get(userId); System.err.println(users.getFullName()); String
		 * adminPage = "users_form.jsp"; request.setAttribute("users", users);
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(adminPage);
		 * dispatcher.forward(request, response);
		 */
	}

	public void updateUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		Users users2 = userDAO.get(userId);
		Users findByEmail = userDAO.findByEmail(email);
		
		if (findByEmail != null && findByEmail.getUserId() != users2.getUserId()) {
			String message = "Could not update user" + email + "already exists";
			request.setAttribute(message, "message");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
		Users users = new Users(userId,email, fullName, password);
		userDAO.update(users); 
		String message = "users has been succesfully updated";
		listUser(message);
		}
	}

	public void deletUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		String message = "User has been deleted successfully";
		if (userId == 1) {
			message = "The default admin user account cannot be deleted.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
			return;
		}
		Users user = userDAO.get(userId);
		if (user == null) {
			message = "Could not find user with ID " + userId + ", or it might have been deleted by another admin";
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		} else {
			userDAO.delete(userId);
			listUser(message);
		}

	}
	
	public void login () throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean loginResult=userDAO.checkLogin(email, password);
	
		if (loginResult) {
			request.getSession().setAttribute("email", email);
			request.getRequestDispatcher("/admin/").forward(request, response);
		}else {
			String message = "User has been login failed";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}
}

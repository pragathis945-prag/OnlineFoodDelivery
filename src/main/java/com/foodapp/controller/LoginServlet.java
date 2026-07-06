package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.dao.impl.UserDAOImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// Read login form data
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println("Email = " + email);
		System.out.println("Password = " + password);

		// Call DAO
		UserDAOImpl dao = new UserDAOImpl();

		User user = dao.getUser(email, password);

		System.out.println("User = " + user);
		if (user != null) {

			// Create session
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", user);

			// Redirect to home page
			response.sendRedirect("restaurants");

		} else {

			// Login failed
			response.sendRedirect("login.jsp");
		}
	}
}
package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.dao.impl.UserDAOImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// Create User object
		User user = new User();

		// Read data from signup page
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		user.setPassword(request.getParameter("password"));
		user.setAddress(request.getParameter("address"));
		user.setRole("CUSTOMER");

		// Call DAO
		UserDAOImpl dao = new UserDAOImpl();

		int result = dao.addUser(user);

		// Check insertion
		if (result > 0) {

			response.sendRedirect("login.jsp");

		} else {

			response.sendRedirect("signup.jsp");

		}
	}
}
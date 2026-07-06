
package com.foodapp.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.foodapp.dao.impl.CartDAOImpl;
import com.foodapp.model.Cart;
import com.foodapp.model.User;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {

	    HttpSession session = request.getSession();

	    User user = (User) session.getAttribute("loggedUser");

	    if (user == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    CartDAOImpl dao = new CartDAOImpl();

	    request.setAttribute("cartList",
	            dao.getAllCartItems(user.getUser_id()));

	    request.getRequestDispatcher("cart.jsp")
	            .forward(request, response);
	}

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();

    	User user = (User) session.getAttribute("loggedUser");

    	String menuIdStr = request.getParameter("menuId");
    	String quantityStr = request.getParameter("quantity");

    	System.out.println("menuId = [" + menuIdStr + "]");
    	System.out.println("quantity = [" + quantityStr + "]");

    	int menuId = Integer.parseInt(menuIdStr);
    	int quantity = Integer.parseInt(quantityStr);
    	Cart cart = new Cart();
    	cart.setUser_id(user.getUser_id());
    	cart.setMenu_id(menuId);
    	cart.setQuantity(quantity);

    	CartDAOImpl dao = new CartDAOImpl();
    	dao.addCart(cart);

    	response.sendRedirect("cart");

    }
}
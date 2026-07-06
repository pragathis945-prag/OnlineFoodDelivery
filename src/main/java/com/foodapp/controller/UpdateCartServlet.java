package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.dao.impl.CartDAOImpl;
import com.foodapp.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int cartId = Integer.parseInt(request.getParameter("cartId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Cart cart = new Cart();

        cart.setCart_id(cartId);
        cart.setQuantity(quantity);

        CartDAOImpl dao = new CartDAOImpl();

        dao.updateCart(cart);

        response.sendRedirect("cart");
    }
}
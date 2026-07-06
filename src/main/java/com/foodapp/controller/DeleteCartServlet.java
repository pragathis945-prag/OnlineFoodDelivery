package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.dao.impl.CartDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCart")
public class DeleteCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int cartId = Integer.parseInt(request.getParameter("cartId"));

        CartDAOImpl dao = new CartDAOImpl();

        dao.deleteCart(cartId);

        response.sendRedirect("cart");
    }
}
package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.impl.MenuDAOImpl;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get restaurant id from URL
        int restaurantId =
                Integer.parseInt(request.getParameter("restaurantId"));

        // Create DAO object
        MenuDAOImpl dao = new MenuDAOImpl();

        // Fetch menu items
        List<Menu> menuList = dao.getMenusByRestaurant(restaurantId);

        // Store in request
        request.setAttribute("menuList", menuList);

        // Open menu page
        request.getRequestDispatcher("menu.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
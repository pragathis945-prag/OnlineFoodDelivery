package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.impl.CartDAOImpl;
import com.foodapp.dao.impl.MenuDAOImpl;
import com.foodapp.dao.impl.OrderDAOImpl;
import com.foodapp.dao.impl.OrderItemDAOImpl;
import com.foodapp.model.Cart;
import com.foodapp.model.Menu;
import com.foodapp.model.Order;
import com.foodapp.model.OrderItem;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String deliveryAddress = request.getParameter("deliveryAddress");
        String paymentMethod = request.getParameter("paymentMethod");

        CartDAOImpl cartDAO = new CartDAOImpl();
        MenuDAOImpl menuDAO = new MenuDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();

        List<Cart> cartList = cartDAO.getAllCartItems(user.getUser_id());

        double totalAmount = 0;

        for (Cart cart : cartList) {

            Menu menu = menuDAO.getMenu(cart.getMenu_id());

            totalAmount += menu.getPrice() * cart.getQuantity();
        }

        Order order = new Order();

        order.setUser_id(user.getUser_id());
        order.setTotal_amount(totalAmount);
        order.setDelivery_address(deliveryAddress);
        order.setPayment_method(paymentMethod);
        order.setOrder_status("Order Placed");

        int orderId = orderDAO.addOrder(order);
        
        if (orderId > 0) {

            for (Cart cart : cartList) {

                Menu menu = menuDAO.getMenu(cart.getMenu_id());

                OrderItem orderItem = new OrderItem();

                orderItem.setOrder_id(orderId);
                orderItem.setMenu_id(cart.getMenu_id());
                orderItem.setQuantity(cart.getQuantity());
                orderItem.setItem_price(menu.getPrice());
                orderItem.setSubtotal(menu.getPrice() * cart.getQuantity());

                orderItemDAO.addOrderItem(orderItem);
            }

            // Clear the user's cart after successful order
            cartDAO.clearCart(user.getUser_id());

            // Send order id to success page
            request.setAttribute("orderId", orderId);

            request.getRequestDispatcher("orderSuccess.jsp")
                   .forward(request, response);

        } else {

            response.getWriter().println("Order Failed!");

        }

    }

}
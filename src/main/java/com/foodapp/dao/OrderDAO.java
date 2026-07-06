package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.Order;

public interface OrderDAO {

    int addOrder(Order order);

    Order getOrder(int orderId);

    List<Order> getAllOrders();

    boolean updateOrder(Order order);

    boolean deleteOrder(int orderId);
}
package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.OrderItem;

public interface OrderItemDAO {

    // Add a new order item
    int addOrderItem(OrderItem orderItem);

    // Get a single order item
    OrderItem getOrderItem(int orderItemId);

    // Get all order items
    List<OrderItem> getAllOrderItems();

    // Update an order item
    boolean updateOrderItem(OrderItem orderItem);

    // Delete an order item
    boolean deleteOrderItem(int orderItemId);
}
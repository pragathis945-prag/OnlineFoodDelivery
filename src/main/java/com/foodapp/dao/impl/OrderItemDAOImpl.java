package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.DBUtil.DBConnection;
import com.foodapp.dao.OrderItemDAO;
import com.foodapp.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

    private Connection connection;

    public OrderItemDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public int addOrderItem(OrderItem orderItem) {

        String query = "INSERT INTO order_items(order_id, menu_id, quantity, item_price, subtotal) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, orderItem.getOrder_id());
            pstmt.setInt(2, orderItem.getMenu_id());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItem_price());
            pstmt.setDouble(5, orderItem.getSubtotal());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public OrderItem getOrderItem(int orderItemId) {

        String query = "SELECT * FROM order_items WHERE order_item_id=?";

        OrderItem orderItem = null;

        try {

            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, orderItemId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                orderItem = new OrderItem();

                orderItem.setOrder_item_id(rs.getInt("order_item_id"));
                orderItem.setOrder_id(rs.getInt("order_id"));
                orderItem.setMenu_id(rs.getInt("menu_id"));
                orderItem.setQuantity(rs.getInt("quantity"));
                orderItem.setItem_price(rs.getDouble("item_price"));
                orderItem.setSubtotal(rs.getDouble("subtotal"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItem;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {

        List<OrderItem> orderItemList = new ArrayList<>();

        String query = "SELECT * FROM order_items";

        try {

            PreparedStatement pstmt = connection.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                OrderItem orderItem = new OrderItem();

                orderItem.setOrder_item_id(rs.getInt("order_item_id"));
                orderItem.setOrder_id(rs.getInt("order_id"));
                orderItem.setMenu_id(rs.getInt("menu_id"));
                orderItem.setQuantity(rs.getInt("quantity"));
                orderItem.setItem_price(rs.getDouble("item_price"));
                orderItem.setSubtotal(rs.getDouble("subtotal"));

                orderItemList.add(orderItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItemList;
    }

    @Override
    public boolean updateOrderItem(OrderItem orderItem) {

        String query = "UPDATE order_items SET quantity=?, item_price=?, subtotal=? WHERE order_item_id=?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, orderItem.getQuantity());
            pstmt.setDouble(2, orderItem.getItem_price());
            pstmt.setDouble(3, orderItem.getSubtotal());
            pstmt.setInt(4, orderItem.getOrder_item_id());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteOrderItem(int orderItemId) {

        String query = "DELETE FROM order_items WHERE order_item_id=?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, orderItemId);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.DBUtil.DBConnection;
import com.foodapp.dao.OrderDAO;
import com.foodapp.model.Order;

public class OrderDAOImpl implements OrderDAO {
	
	private Connection connection;

	public OrderDAOImpl() {
	    connection = DBConnection.getConnection();
	}

	@Override
	public int addOrder(Order order) {

	    String query = "INSERT INTO orders(user_id, total_amount, delivery_address, payment_method, order_status) VALUES (?, ?, ?, ?, ?)";

	    try {

	    	PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

	        pstmt.setInt(1, order.getUser_id());
	        pstmt.setDouble(2, order.getTotal_amount());
	        pstmt.setString(3, order.getDelivery_address());
	        pstmt.setString(4, order.getPayment_method());
	        pstmt.setString(5, order.getOrder_status());

	        int rows = pstmt.executeUpdate();

	        if (rows > 0) {

	            ResultSet rs = pstmt.getGeneratedKeys();

	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}
	@Override
	public Order getOrder(int orderId) {

	    String query = "SELECT * FROM orders WHERE order_id = ?";
	    Order order = null;

	    try {

	        PreparedStatement pstmt = connection.prepareStatement(query);
	        pstmt.setInt(1, orderId);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {

	            order = new Order();

	            order.setOrder_id(rs.getInt("order_id"));
	            order.setUser_id(rs.getInt("user_id"));
	            order.setOrder_date(rs.getTimestamp("order_date"));
	            order.setTotal_amount(rs.getDouble("total_amount"));
	            order.setDelivery_address(rs.getString("delivery_address"));
	            order.setPayment_method(rs.getString("payment_method"));
	            order.setOrder_status(rs.getString("order_status"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return order;
	}
	@Override
	public List<Order> getAllOrders() {

	    List<Order> orderList = new ArrayList<>();

	    String query = "SELECT * FROM orders";

	    try {

	        PreparedStatement pstmt = connection.prepareStatement(query);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {

	            Order order = new Order();

	            order.setOrder_id(rs.getInt("order_id"));
	            order.setUser_id(rs.getInt("user_id"));
	            order.setOrder_date(rs.getTimestamp("order_date"));
	            order.setTotal_amount(rs.getDouble("total_amount"));
	            order.setDelivery_address(rs.getString("delivery_address"));
	            order.setPayment_method(rs.getString("payment_method"));
	            order.setOrder_status(rs.getString("order_status"));

	            orderList.add(order);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return orderList;
	}

	@Override
	public boolean updateOrder(Order order) {

	    String query = "UPDATE orders SET total_amount=?, delivery_address=?, payment_method=?, order_status=? WHERE order_id=?";

	    try {

	        PreparedStatement pstmt = connection.prepareStatement(query);

	        pstmt.setDouble(1, order.getTotal_amount());
	        pstmt.setString(2, order.getDelivery_address());
	        pstmt.setString(3, order.getPayment_method());
	        pstmt.setString(4, order.getOrder_status());
	        pstmt.setInt(5, order.getOrder_id());

	        return pstmt.executeUpdate() > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}

	@Override
	public boolean deleteOrder(int orderId) {

	    String query = "DELETE FROM orders WHERE order_id=?";

	    try {

	        PreparedStatement pstmt = connection.prepareStatement(query);

	        pstmt.setInt(1, orderId);

	        return pstmt.executeUpdate() > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
}
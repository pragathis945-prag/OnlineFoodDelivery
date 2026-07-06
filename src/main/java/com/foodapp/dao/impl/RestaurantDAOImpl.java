package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.DBUtil.DBConnection;
import com.foodapp.dao.RestaurantDAO;
import com.foodapp.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	// Database Connection Object
	private Connection connection;

	// Constructor
	public RestaurantDAOImpl() {
	    connection = DBConnection.getConnection();
	}
	@Override
	public int addRestaurant(Restaurant restaurant) {

	    int status = 0;

	    try {

	        String sql = "INSERT INTO restaurants(name, cuisine_type, address, phone, image_path, rating, is_active) VALUES(?,?,?,?,?,?,?)";

	        PreparedStatement pstmt = connection.prepareStatement(sql);

	        pstmt.setString(1, restaurant.getName());
	        pstmt.setString(2, restaurant.getCuisine_type());
	        pstmt.setString(3, restaurant.getAddress());
	        pstmt.setString(4, restaurant.getPhone());
	        pstmt.setString(5, restaurant.getImage_path());
	        pstmt.setDouble(6, restaurant.getRating());
	        pstmt.setBoolean(7, restaurant.isIs_active());

	        status = pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}

	@Override
	public Restaurant getRestaurant(int restaurant_id) {

	    Restaurant restaurant = null;

	    try {

	        String sql = "SELECT * FROM restaurants WHERE restaurant_id=?";

	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setInt(1, restaurant_id);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {

	            restaurant = new Restaurant();

	            restaurant.setRestaurant_id(rs.getInt("restaurant_id"));
	            restaurant.setName(rs.getString("name"));
	            restaurant.setCuisine_type(rs.getString("cuisine_type"));
	            restaurant.setAddress(rs.getString("address"));
	            restaurant.setPhone(rs.getString("phone"));
	            restaurant.setImage_path(rs.getString("image_path"));
	            restaurant.setRating(rs.getDouble("rating"));
	            restaurant.setIs_active(rs.getBoolean("is_active"));
	            restaurant.setCreated_at(rs.getTimestamp("created_at"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return restaurant;
	}
	
	
	@Override
	public List<Restaurant> getAllRestaurants() {

	    // Create an empty list
	    List<Restaurant> restaurantList = new ArrayList<>();

	    try {

	        // SQL Query
	        String sql = "SELECT * FROM restaurants";

	        // Execute query
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        // Read all rows
	        while (rs.next()) {

	            Restaurant restaurant = new Restaurant();

	            restaurant.setRestaurant_id(rs.getInt("restaurant_id"));
	            restaurant.setName(rs.getString("name"));
	            restaurant.setCuisine_type(rs.getString("cuisine_type"));
	            restaurant.setAddress(rs.getString("address"));
	            restaurant.setPhone(rs.getString("phone"));
	            restaurant.setImage_path(rs.getString("image_path"));
	            restaurant.setRating(rs.getDouble("rating"));
	            restaurant.setIs_active(rs.getBoolean("is_active"));
	            restaurant.setCreated_at(rs.getTimestamp("created_at"));

	            restaurantList.add(restaurant);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return restaurantList;
	}



	@Override
	public int updateRestaurant(Restaurant restaurant) {

	    int status = 0;

	    try {

	        String sql = "UPDATE restaurants SET name=?, cuisine_type=?, address=?, phone=?, image_path=?, rating=?, is_active=? WHERE restaurant_id=?";

	        PreparedStatement pstmt = connection.prepareStatement(sql);

	        pstmt.setString(1, restaurant.getName());
	        pstmt.setString(2, restaurant.getCuisine_type());
	        pstmt.setString(3, restaurant.getAddress());
	        pstmt.setString(4, restaurant.getPhone());
	        pstmt.setString(5, restaurant.getImage_path());
	        pstmt.setDouble(6, restaurant.getRating());
	        pstmt.setBoolean(7, restaurant.isIs_active());
	        pstmt.setInt(8, restaurant.getRestaurant_id());

	        status = pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}

	@Override
	public int deleteRestaurant(int restaurant_id) {

	    int status = 0;

	    try {

	        String sql = "DELETE FROM restaurants WHERE restaurant_id=?";

	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setInt(1, restaurant_id);

	        status = pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
}
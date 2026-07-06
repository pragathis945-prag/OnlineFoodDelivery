package com.foodapp.dao.impl;

import java.sql.Connection;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.foodapp.DBUtil.DBConnection;
import com.foodapp.dao.MenuDAO;
import com.foodapp.model.Menu;

public class MenuDAOImpl implements MenuDAO {

    // Database Connection Object
    private Connection connection;

    // Constructor
    public MenuDAOImpl() {
        connection = DBConnection.getConnection();
    }

	@Override
	public int addMenu(Menu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Menu getMenu(int menu_id) {

	    Menu menu = null;

	    try {

	        String sql = "SELECT * FROM menu WHERE menu_id=?";

	        PreparedStatement pstmt = connection.prepareStatement(sql);

	        pstmt.setInt(1, menu_id);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {

	            menu = new Menu();

	            menu.setMenu_id(rs.getInt("menu_id"));
	            menu.setRestaurant_id(rs.getInt("restaurant_id"));
	            menu.setItem_name(rs.getString("item_name"));
	            menu.setDescription(rs.getString("description"));
	            menu.setPrice(rs.getDouble("price"));
	            menu.setCategory(rs.getString("category"));
	            menu.setIs_available(rs.getBoolean("is_available"));
	            menu.setImage_url(rs.getString("image_url"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return menu;
	}

	@Override
	public List<Menu> getAllMenus() {

	    List<Menu> menuList = new ArrayList<>();

	    try {

	        String sql = "SELECT * FROM menu";

	        PreparedStatement pstmt = connection.prepareStatement(sql);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {

	            Menu menu = new Menu();

	            menu.setMenu_id(rs.getInt("menu_id"));
	            menu.setRestaurant_id(rs.getInt("restaurant_id"));
	            menu.setItem_name(rs.getString("item_name"));
	            menu.setDescription(rs.getString("description"));
	            menu.setPrice(rs.getDouble("price"));
	            menu.setCategory(rs.getString("category"));
	            menu.setIs_available(rs.getBoolean("is_available"));
	            menu.setImage_url(rs.getString("image_url"));

	            menuList.add(menu);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return menuList;
	}
	@Override
	public List<Menu> getMenusByRestaurant(int restaurant_id) {

	    // Create list to store menu items
	    List<Menu> menuList = new ArrayList<>();

	    try {

	        // SQL Query
	        String sql = "SELECT * FROM menu WHERE restaurant_id = ?";

	        // Prepare query
	        PreparedStatement pstmt = connection.prepareStatement(sql);

	        // Set restaurant id
	        pstmt.setInt(1, restaurant_id);

	        // Execute query
	        ResultSet rs = pstmt.executeQuery();

	        // Read all rows
	        while (rs.next()) {

	            Menu menu = new Menu();

	            menu.setMenu_id(rs.getInt("menu_id"));
	            menu.setRestaurant_id(rs.getInt("restaurant_id"));
	            menu.setItem_name(rs.getString("item_name"));
	            menu.setDescription(rs.getString("description"));
	            menu.setPrice(rs.getDouble("price"));
	            menu.setCategory(rs.getString("category"));
	            menu.setIs_available(rs.getBoolean("is_available"));
	            menu.setImage_url(rs.getString("image_url"));

	            menuList.add(menu);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return menuList;
	}
	@Override
	public int updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMenu(int menu_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
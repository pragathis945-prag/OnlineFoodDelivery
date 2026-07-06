package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.DBUtil.DBConnection;
import com.foodapp.dao.UserDAO;
import com.foodapp.model.User;

public class UserDAOImpl implements UserDAO {

	private Connection con;

	public UserDAOImpl() {

		con = DBConnection.getConnection();
	}

	@Override
	public int addUser(User user) {

		String query = "INSERT INTO users(name,email,phone,password,address,role) VALUES(?,?,?,?,?,?)";

		try {

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getRole());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public User getUser(int user_id) {

		String query = "SELECT * FROM users WHERE user_id=?";

		User user = null;

		try {

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, user_id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				user = new User();

				user.setUser_id(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				user.setCreated_at(rs.getTimestamp("created_at"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public List<User> getAllUsers() {

		String query = "SELECT * FROM users";

		List<User> userList = new ArrayList<>();

		try {

			PreparedStatement pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				User user = new User();

				user.setUser_id(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				user.setCreated_at(rs.getTimestamp("created_at"));

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public int updateUser(User user) {

		String query = "UPDATE users SET name=?, email=?, phone=?, password=?, address=?, role=? WHERE user_id=?";

		try {

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getRole());
			pstmt.setInt(7, user.getUser_id());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteUser(int user_id) {

		String query = "DELETE FROM users WHERE user_id=?";

		try {

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, user_id);

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	// Login User
	@Override
	public User getUser(String email, String password) {

		String query = "SELECT * FROM users WHERE email=? AND password=?";

		User user = null;

		try {

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				user = new User();

				user.setUser_id(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				user.setCreated_at(rs.getTimestamp("created_at"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}
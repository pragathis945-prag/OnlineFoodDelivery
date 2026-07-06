package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.User;

public interface UserDAO {

	// Add a new user
	int addUser(User user);

	// Get user by ID
	User getUser(int user_id);

	// Get all users
	List<User> getAllUsers();

	// Update user details
	int updateUser(User user);

	// Delete user by ID
	int deleteUser(int user_id);
	
	// Login user using email and password
	User getUser(String email, String password);
}
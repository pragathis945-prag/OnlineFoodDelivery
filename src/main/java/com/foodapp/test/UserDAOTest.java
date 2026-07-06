package com.foodapp.test;

import com.foodapp.dao.impl.UserDAOImpl;
import com.foodapp.model.User;

public class UserDAOTest {

	public static void main(String[] args) {

		UserDAOImpl dao = new UserDAOImpl();

		User user = new User();

		user.setName("rashmi");
		user.setEmail("rahul@gmail.com");
		user.setPhone("9876565438");
		user.setPassword("rahul123");
		user.setAddress("Bangalore");
		user.setRole("CUSTOMER");

		int result = dao.addUser(user);

		if (result > 0) {
			System.out.println("User Added Successfully");
		} else {
			System.out.println("User Not Added");
		}
	}
}
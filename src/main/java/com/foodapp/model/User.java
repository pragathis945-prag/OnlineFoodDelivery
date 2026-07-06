
	package com.foodapp.model;

	import java.sql.Timestamp;

	public class User {

		// Variables matching the database columns exactly

		private int user_id;
		private String name;
		private String email;
		private String phone;
		private String password;
		private String address;
		private String role;
		private Timestamp created_at;

		// Default Constructor
		public User() {

		}

		// Parameterized Constructor
		public User(int user_id, String name, String email, String phone,
				String password, String address, String role,
				Timestamp created_at) {

			this.user_id = user_id;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.password = password;
			this.address = address;
			this.role = role;
			this.created_at = created_at;
		}

		// Getters and Setters

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Timestamp getCreated_at() {
			return created_at;
		}

		public void setCreated_at(Timestamp created_at) {
			this.created_at = created_at;
		}

		@Override
		public String toString() {
			return "User [user_id=" + user_id
					+ ", name=" + name
					+ ", email=" + email
					+ ", phone=" + phone
					+ ", password=" + password
					+ ", address=" + address
					+ ", role=" + role
					+ ", created_at=" + created_at + "]";
		}
	}


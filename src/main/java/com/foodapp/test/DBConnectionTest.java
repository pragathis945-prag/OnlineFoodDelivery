package com.foodapp.test;

import java.sql.Connection;

import com.foodapp.DBUtil.DBConnection;

public class DBConnectionTest {

    public static void main(String[] args) {

        // Calling the getConnection() method
        Connection con = DBConnection.getConnection();

        // Checking whether the connection is successful or not 
        if (con != null) {
            System.out.println("Connection Successful");
        } else {
            System.out.println("Connection Failed");
        }
    }
}
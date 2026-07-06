package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.DBUtil.DBConnection;
import com.foodapp.dao.CartDAO;
import com.foodapp.model.Cart;

/*
 * CartDAO Implementation
 */

public class CartDAOImpl implements CartDAO {

    // Database connection object
    private Connection connection;

    // Constructor
    public CartDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public int addCart(Cart cart) {

        try {

            // Check whether the item already exists in the cart
            String checkSql = "SELECT cart_id, quantity FROM cart WHERE user_id=? AND menu_id=?";

            PreparedStatement checkStmt = connection.prepareStatement(checkSql);
            checkStmt.setInt(1, cart.getUser_id());
            checkStmt.setInt(2, cart.getMenu_id());

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {

                // Item already exists, increase quantity
                int oldQuantity = rs.getInt("quantity");
                int newQuantity = oldQuantity + cart.getQuantity();

                String updateSql = "UPDATE cart SET quantity=? WHERE cart_id=?";

                PreparedStatement updateStmt = connection.prepareStatement(updateSql);
                updateStmt.setInt(1, newQuantity);
                updateStmt.setInt(2, rs.getInt("cart_id"));

                return updateStmt.executeUpdate();

            } else {

                // Item doesn't exist, insert new row
                String insertSql = "INSERT INTO cart(user_id, menu_id, quantity) VALUES(?,?,?)";

                PreparedStatement insertStmt = connection.prepareStatement(insertSql);

                insertStmt.setInt(1, cart.getUser_id());
                insertStmt.setInt(2, cart.getMenu_id());
                insertStmt.setInt(3, cart.getQuantity());

                return insertStmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Cart getCart(int cart_id) {

        String sql = "SELECT * FROM cart WHERE cart_id=?";

        Cart cart = null;

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, cart_id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                cart = new Cart();

                cart.setCart_id(rs.getInt("cart_id"));
                cart.setUser_id(rs.getInt("user_id"));
                cart.setMenu_id(rs.getInt("menu_id"));
                cart.setQuantity(rs.getInt("quantity"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cart;
    }

    @Override
    public List<Cart> getAllCartItems(int user_id) {

        List<Cart> cartList = new ArrayList<>();

        String sql = "SELECT c.cart_id, c.user_id, c.menu_id, c.quantity, "
                + "m.item_name, m.price, "
                + "(c.quantity * m.price) AS subtotal "
                + "FROM cart c "
                + "INNER JOIN menu m ON c.menu_id = m.menu_id "
                + "WHERE c.user_id = ?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, user_id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Cart cart = new Cart();

                cart.setCart_id(rs.getInt("cart_id"));
                cart.setUser_id(rs.getInt("user_id"));
                cart.setMenu_id(rs.getInt("menu_id"));
                cart.setQuantity(rs.getInt("quantity"));

                cart.setItem_name(rs.getString("item_name"));
                cart.setPrice(rs.getDouble("price"));
                cart.setSubtotal(rs.getDouble("price") * rs.getInt("quantity"));

                cartList.add(cart);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cartList;
    }

    @Override
    public int updateCart(Cart cart) {

        String sql = "UPDATE cart SET quantity=? WHERE cart_id=?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, cart.getQuantity());
            pstmt.setInt(2, cart.getCart_id());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteCart(int cart_id) {

        String sql = "DELETE FROM cart WHERE cart_id=?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, cart_id);

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int clearCart(int user_id) {

        String sql = "DELETE FROM cart WHERE user_id=?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, user_id);

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    

}
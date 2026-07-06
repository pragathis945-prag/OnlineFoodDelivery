package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.Cart;

/*
 * CartDAO Interface
 * Contains all database operations for Cart table.
 */

public interface CartDAO {

    // Add item to cart
    int addCart(Cart cart);

    // Get one cart item
    Cart getCart(int cart_id);

    // Get all cart items of a user
    List<Cart> getAllCartItems(int user_id);

    // Update quantity
    int updateCart(Cart cart);

    // Remove one item
    int deleteCart(int cart_id);

    // Clear entire cart of a user
    int clearCart(int user_id);
}
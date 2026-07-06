package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.Restaurant;

/*
 * Restaurant DAO Interface
 * Contains all CRUD methods
 */

public interface RestaurantDAO {

    // Add restaurant
    int addRestaurant(Restaurant restaurant);

    // Get restaurant by id
    Restaurant getRestaurant(int restaurant_id);

    // Get all restaurants
    List<Restaurant> getAllRestaurants();

    // Update restaurant
    int updateRestaurant(Restaurant restaurant);

    // Delete restaurant
    int deleteRestaurant(int restaurant_id);
}
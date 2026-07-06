package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.Menu;

/*
 * MenuDAO Interface
 * Contains all database operations for Menu table.
 */
public interface MenuDAO {

    // Add a new menu item
    int addMenu(Menu menu);

    // Get one menu item using menu_id
    Menu getMenu(int menu_id);

    // Get all menu items
    List<Menu> getAllMenus();

    // Get all menu items of a particular restaurant
    List<Menu> getMenusByRestaurant(int restaurant_id);

    // Update menu item
    int updateMenu(Menu menu);

    // Delete menu item
    int deleteMenu(int menu_id);
}
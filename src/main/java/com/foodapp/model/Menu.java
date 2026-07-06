package com.foodapp.model;

/*
 * Menu Model Class
 * Represents one record from the menu table.
 */

public class Menu {

    // Variables matching menu table columns

    private int menu_id;
    private int restaurant_id;
    private String item_name;
    private String description;
    private double price;
    private String category;
    private boolean is_available;
    private String image_url;

    // Default Constructor
    public Menu() {

    }

    // Parameterized Constructor
    public Menu(int menu_id, int restaurant_id, String item_name,
            String description, double price,
            String category, boolean is_available,
            String image_url) {

        this.menu_id = menu_id;
        this.restaurant_id = restaurant_id;
        this.item_name = item_name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.is_available = is_available;
        this.image_url = image_url;
    }

    // Getters and Setters

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}
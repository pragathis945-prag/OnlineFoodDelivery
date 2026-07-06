package com.foodapp.model;

/*
 * Cart Model Class
 * Represents one cart item.
 */

public class Cart {

    private int cart_id;
    private int user_id;
    private int menu_id;
    private int quantity;
    private double total_price;

    // New fields
    private String item_name;
    private double price;
    private double subtotal;

    // Default Constructor
    public Cart() {

    }

    // Parameterized Constructor
    public Cart(int cart_id, int user_id, int menu_id,
            int quantity, double total_price) {

        this.cart_id = cart_id;
        this.user_id = user_id;
        this.menu_id = menu_id;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    // New Getters and Setters

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
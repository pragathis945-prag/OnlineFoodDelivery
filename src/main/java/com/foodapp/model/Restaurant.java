package com.foodapp.model;

import java.sql.Timestamp;

/*
 * Restaurant Model Class
 * This class represents one record from the restaurant table.
 */
public class Restaurant {

    // Variables matching restaurant table columns
    private int restaurant_id;
    private String name;
    private String cuisine_type;
    private String address;
    private String phone;
    private String image_path;
    private double rating;
    private boolean is_active;
    private Timestamp created_at;

    // Default Constructor
    public Restaurant() {

    }

    // Parameterized Constructor
    public Restaurant(int restaurant_id, String name, String cuisine_type,
            String address, String phone, String image_path,
            double rating, boolean is_active, Timestamp created_at) {

        this.restaurant_id = restaurant_id;
        this.name = name;
        this.cuisine_type = cuisine_type;
        this.address = address;
        this.phone = phone;
        this.image_path = image_path;
        this.rating = rating;
        this.is_active = is_active;
        this.created_at = created_at;
    }

    // Getters and Setters

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine_type() {
        return cuisine_type;
    }

    public void setCuisine_type(String cuisine_type) {
        this.cuisine_type = cuisine_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

}
package com.foodapp.model;

import java.sql.Timestamp;

/*
 * Order Model Class
 * Represents one record from the orders table.
 */

public class Order {

    // Variables matching the orders table columns

    private int order_id;
    private int user_id;
    private Timestamp order_date;
    private double total_amount;
    private String delivery_address;
    private String payment_method;
    private String order_status;

    // Default Constructor
    public Order() {
    }

    // Parameterized Constructor
    public Order(int order_id, int user_id, Timestamp order_date,
            double total_amount, String delivery_address,
            String payment_method, String order_status) {

        this.order_id = order_id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
        this.delivery_address = delivery_address;
        this.payment_method = payment_method;
        this.order_status = order_status;
    }

    // Getters and Setters

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Order [order_id=" + order_id
                + ", user_id=" + user_id
                + ", order_date=" + order_date
                + ", total_amount=" + total_amount
                + ", delivery_address=" + delivery_address
                + ", payment_method=" + payment_method
                + ", order_status=" + order_status + "]";
    }
}
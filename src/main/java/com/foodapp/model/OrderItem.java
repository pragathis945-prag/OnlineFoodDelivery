package com.foodapp.model;

public class OrderItem {

    private int order_item_id;
    private int order_id;
    private int menu_id;
    private int quantity;
    private double item_price;
    private double subtotal;

    public OrderItem() {

    }

    public OrderItem(int order_item_id, int order_id, int menu_id,
            int quantity, double item_price, double subtotal) {

        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.menu_id = menu_id;
        this.quantity = quantity;
        this.item_price = item_price;
        this.subtotal = subtotal;
    }

    public int getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "OrderItem [order_item_id=" + order_item_id
                + ", order_id=" + order_id
                + ", menu_id=" + menu_id
                + ", quantity=" + quantity
                + ", item_price=" + item_price
                + ", subtotal=" + subtotal + "]";
    }
}
package com.ai.model;

public class Shop_order {
    private int id;
    private String order_date;
    private double order_total;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOrder_date() {
        return order_date;
    }
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    public double getOrder_total() {
        return order_total;
    }
    public void setOrder_total(double order_total) {
        this.order_total = order_total;
    }
    public String getOrder_status() {
        return order_status;
    }
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
    public double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    private String order_status;
    private double total_price;

}

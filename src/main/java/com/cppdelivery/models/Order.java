package com.cppdelivery.models;
// Min
// Use Builder Class-- create OrderBuilder


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Restaurant restaurant;
    private final Customer customer;
    private final Driver driver;
    private final List<String> foodItemList;
    private final LocalDateTime orderCreationTime;
    private LocalDateTime orderPickUpTime;
    private LocalDateTime orderDeliveredTime;

    public Order(Restaurant restaurant, Customer customer, Driver driver, List<String> foodItemList, LocalDateTime orderCreationTime){
        this.restaurant = restaurant;
        this.customer = customer;
        this.driver = driver;
        this.foodItemList = foodItemList;
        this.orderCreationTime = orderCreationTime;
    }

    public void setOrderPickUpTime(LocalDateTime orderPickUpTime) {
        this.orderPickUpTime = orderPickUpTime;
    }

    public void setOrderDeliveredTime(LocalDateTime orderDeliveredTime){
        this.orderDeliveredTime = orderDeliveredTime;
    }

    public Restaurant getRestaurant(){
        return restaurant;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Driver getDriver(){
        return driver;
    }
    public List<String> getFoodItemList(){
        return foodItemList;
    }
    public LocalDateTime getOrderCreationTime(){
        return orderCreationTime;
    }
    public LocalDateTime getOrderPickUpTime(){
        return orderPickUpTime;
    }
    public LocalDateTime getOrderDeliveredTime(){
        return orderDeliveredTime;
    }
}

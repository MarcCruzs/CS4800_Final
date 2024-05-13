package com.cppdelivery.models;
// Min
// Use Builder Class-- create OrderBuilder
import com.cppdelivery.models.restaurants.Restaurant;
import com.cppdelivery.models.restaurants.food.Meal;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;
    private final List<Meal> foodItemList;
    private LocalDateTime orderCreationTime;
    private LocalDateTime orderPickUpTime;
    private LocalDateTime orderDeliveredTime;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Order(Restaurant restaurant, Customer customer, Driver driver, List<Meal> foodItemList, LocalDateTime orderCreationTime){
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
    public List<Meal> getFoodItemList(){
        return foodItemList;
    }
    public void displayFoodItems() {
        foodItemList.forEach(Meal::display);
    }
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Meal meal : foodItemList) {
            totalPrice += meal.getPrice();
        }
        return totalPrice;
    }
    public String getOrderCreationTimeString(){
        return orderCreationTime.format(formatter);
    }
    public String getOrderPickUpTimeString(){
        if(orderPickUpTime != null)
            return orderPickUpTime.format(formatter);
        else
            return "Not picked up yet";
    }
    public String getOrderDeliveredTimeString(){
        if(orderDeliveredTime != null)
            return orderDeliveredTime.format(formatter);
        else
            return "Not delivered up yet";
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public LocalDateTime getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(LocalDateTime orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public LocalDateTime getOrderPickUpTime() {
        return orderPickUpTime;
    }

    public LocalDateTime getOrderDeliveredTime() {
        return orderDeliveredTime;
    }
}

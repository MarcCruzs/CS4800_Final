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
    private String orderCreationTime;
    private String orderPickUpTime;
    private String orderDeliveredTime;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Order(Restaurant restaurant, Customer customer, Driver driver, List<Meal> foodItemList, String orderCreationTime){
        this.restaurant = restaurant;
        this.customer = customer;
        this.driver = driver;
        this.foodItemList = foodItemList;
        this.orderCreationTime = orderCreationTime;
    }

    public void setOrderPickUpTime(String orderPickUpTime) {
        this.orderPickUpTime = orderPickUpTime;
    }

    public void setOrderDeliveredTime(String orderDeliveredTime){
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
        return orderCreationTime;
    }
    public String getOrderPickUpTimeString(){
        if(orderPickUpTime != null)
            return orderPickUpTime;
        else
            return "Not picked up yet";
    }
    public String getOrderDeliveredTimeString(){
        if(orderDeliveredTime != null)
            return orderDeliveredTime;
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

    public String getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(String orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public String getOrderPickUpTime() {
        return orderPickUpTime;
    }

    public String getOrderDeliveredTime() {
        return orderDeliveredTime;
    }
}

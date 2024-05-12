package com.cppdelivery.models;

import java.time.LocalDateTime;
import java.util.List;

public class OrderBuilder implements Builder{
    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;
    private List<String> foodItemList;
    private LocalDateTime orderCreationTime;
    private LocalDateTime orderPickUpTime;
    private LocalDateTime orderDeliveredTime;

    @Override
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void setFoodItemList(List<String> foodItemList) {
        this.foodItemList = foodItemList;
    }

    @Override
    public void setOrderCreationTime(LocalDateTime orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public Order getResult(){
        return new Order(restaurant, customer, driver, foodItemList, orderCreationTime);
    }
}

package com.cppdelivery.models;
import com.cppdelivery.models.restaurants.Restaurant;
import com.cppdelivery.models.restaurants.food.Meal;

import java.time.LocalDateTime;
import java.util.List;

public class OrderBuilder implements Builder{
    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;
    private List<Meal> foodItemList;
    private String orderCreationTime;
    private String orderPickUpTime;
    private String orderDeliveredTime;

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
    public void setOrderCreationTime(String orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public Order getResult(){
        return new Order(restaurant, customer, driver, orderCreationTime);
    }
}

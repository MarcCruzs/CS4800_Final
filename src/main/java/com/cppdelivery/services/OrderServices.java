package com.cppdelivery.services;

import com.cppdelivery.models.*;
import com.cppdelivery.models.restaurants.Restaurant;
import com.cppdelivery.models.restaurants.food.Meal;

import java.time.LocalDateTime;
import java.util.List;

public class OrderServices {
    private final Builder orderBuilder;
    public  OrderServices(Builder orderBuilder){
        this.orderBuilder = orderBuilder;
    }
    public Order buildOrder(Restaurant restaurant, Customer customer, Driver driver, String orderCreationTime){
        orderBuilder.setRestaurant(restaurant);
        orderBuilder.setCustomer(customer);
        orderBuilder.setDriver(driver);
        orderBuilder.setOrderCreationTime(orderCreationTime);

        // Get the order from the builder
        Order order = ((OrderBuilder) orderBuilder).getResult();

        // Additional logic if needed, such as saving the order to a database or notifying stakeholders

        return order;
    }
}

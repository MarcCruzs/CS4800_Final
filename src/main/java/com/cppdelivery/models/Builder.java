package com.cppdelivery.models;
import com.cppdelivery.models.restaurants.Restaurant;
import com.cppdelivery.models.food.Meal;

import java.util.List;

public interface Builder {
    void setRestaurant(Restaurant restaurant);
    void setCustomer(Customer customer);
    void setDriver(Driver driver);
    void setOrderCreationTime(String orderCreationTime);

}

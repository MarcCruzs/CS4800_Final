package com.cppdelivery.models;
import com.cppdelivery.models.restaurants.Restaurant;
import com.cppdelivery.models.restaurants.food.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface Builder {
    void setRestaurant(Restaurant restaurant);
    void setCustomer(Customer customer);
    void setDriver(Driver driver);
    void setFoodItemList(List<Meal> foodItemList);
    void setOrderCreationTime(String orderCreationTime);

}

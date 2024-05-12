package com.cppdelivery.models;

import java.time.LocalDateTime;
import java.util.List;

public interface Builder {
    void setRestaurant(Restaurant restaurant);
    void setCustomer(Customer customer);
    void setDriver(Driver driver);
    void setFoodItemList(List<String> foodItemList);
    void setOrderCreationTime(LocalDateTime orderCreationTime);

}

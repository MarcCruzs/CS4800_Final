package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.restaurants.macronutrient.*;
import com.cppdelivery.utils.*;

public class ItalianRestaurant extends Restaurant {
    public ItalianRestaurant(String name, String address, Counties county, RestaurantOperatingHours operatingHours) {
        super(name, address, county, operatingHours);
        setCuisine(CuisineTypes.ITALIAN);
    }
    @Override
    protected void setupMenu() {
        // setup menu specifics
    }
}

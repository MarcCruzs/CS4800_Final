package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.restaurants.food.*;
import com.cppdelivery.utils.*;

public class ItalianRestaurant extends Restaurant {
    public ItalianRestaurant(String name, String address, Counties county, RestaurantOperatingHours operatingHours) {
        super(name, address, county, operatingHours);
        setCuisine(CuisineTypes.ITALIAN);
    }
    @Override
    protected void setupMenu() {
        Meal pastaBolognese = new Meal("Pasta Bolognese", new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        this.addItem(pastaBolognese);
    }
}

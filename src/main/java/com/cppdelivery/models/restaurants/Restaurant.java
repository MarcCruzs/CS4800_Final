package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.restaurants.food.*;
import com.cppdelivery.utils.*;

public class Restaurant {
    final private String name;
    final private String address;
    private Menu menu;
    private CuisineTypes cuisine;
    final private Counties county;
    final private RestaurantOperatingHours operatingHours;
    public Restaurant(String name, String address, Counties county, RestaurantOperatingHours operatingHours) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.operatingHours = operatingHours;

        this.menu = new Menu();
        setupMenu();
    }

    protected void setCuisine(CuisineTypes cuisine) {
        this.cuisine = cuisine;
    }

    protected void setupMenu() {
        // Default menu setup can be empty or contain some common meals
    }

    public void addItem(Meal item) {
        this.menu.addItem(item);
    }

    public void showDetails() {
        System.out.println("Restaurant Name: " + name);
        System.out.println("Cuisine type: " + cuisine.toString());
        System.out.println("Address: " + address);
        System.out.println("County: " + county.toString());
        System.out.println("Operating Hours: " + operatingHours.toString());
        menu.showMenu();
    }
}

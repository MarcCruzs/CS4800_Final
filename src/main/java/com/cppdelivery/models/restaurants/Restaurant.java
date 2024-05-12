package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.restaurants.macronutrient.*;
import com.cppdelivery.utils.*;

import java.util.List;

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

    public void addMeal(String name, Carb carb, List<Carb> alternativeCarbs, Protein protein, List<Protein> alternativeProteins, Fat fat, List<Fat> alternativeFats) {
        MenuItem item = new MenuItem(name, carb, alternativeCarbs, protein, alternativeProteins, fat, alternativeFats);
        this.menu.addMeal(item);
    }

    public void showDetails() {
        System.out.println("Restaurant Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("County: " + county.toString());
        System.out.println("Operating Hours: " + operatingHours.toString());
        menu.showMenu();
    }
}

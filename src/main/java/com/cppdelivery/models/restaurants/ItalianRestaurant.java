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
        Meal pastaBolognese = new Meal("Bolognese Pasta", 22, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        this.addItem(pastaBolognese);

        Meal pastaAlfredo = new Meal("Alfredo Pasta", 17, new Carb.Pasta(), new Protein.Chicken(), new Fat.Butter());
        this.addItem(pastaAlfredo);

        Meal pastaPesto = new Meal("Pesto Pasta", 17, new Carb.Pasta(), new Protein.Chicken(), new Fat.Pesto());
        this.addItem(pastaPesto);

        Meal risotto = new Meal("Risotto", 18, new Carb.Rice(), new Protein.Chicken(), new Fat.Butter());
        this.addItem(risotto);
    }
}

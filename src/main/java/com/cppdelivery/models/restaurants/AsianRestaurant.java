package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.restaurants.food.*;
import com.cppdelivery.utils.*;

public class AsianRestaurant extends Restaurant {
    public AsianRestaurant(String name, String address, Counties county, RestaurantOperatingHours operatingHours) {
        super(name, address, county, operatingHours);
        setCuisine(CuisineTypes.ASIAN);
    }
    @Override
    protected void setupMenu() {
        Meal spicyWonton = new Meal("Spicy Wonton", 12, new Carb.Flour(), new Protein.Beef(), new Fat.OliveOil());
        this.addItem(spicyWonton);

        Meal friedTofuWithRice = new Meal("Fried Tofu w/ Rice", 10, new Carb.Rice() , new Protein.Tofu(), new Fat.OliveOil());
        this.addItem(friedTofuWithRice);

        Meal orangeChicken = new Meal("Orange Chicke", 13, new Carb.Flour(), new Protein.Chicken(), new Fat.Butter());
        this.addItem(orangeChicken);

        Meal sesameSalad = new Meal("Sesame Salad", 14, new Carb.Quinoa(), new Protein.Chicken(), new Fat.Almond());
        this.addItem(sesameSalad);
    }
}

package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.food.*;
import com.cppdelivery.utils.*;

public class MexicanRestaurant extends Restaurant {
    public MexicanRestaurant(String name, String address, Counties county, RestaurantOperatingHours operatingHours, double preparationTime) {
        super(name, address, county, operatingHours, preparationTime);
        setCuisine(CuisineTypes.MEXICAN);
    }
    @Override
    protected void setupMenu() {
        Meal chickenQuesadilla = new Meal("Chicken Quesadilla", 10, new Carb.Tortilla(), new Protein.Chicken(), new Fat.Cheese());
        this.addItem(chickenQuesadilla);

        Meal beefTacos = new Meal("Beef Tacos", 12, new Carb.Tortilla(), new Protein.Beef(), new Fat.Cheese());
        this.addItem(beefTacos);

        Meal chilesRellenos = new Meal("Chiles Rellenos", 8, new Carb.Flour(), new Protein.Chicken(), new Fat.Cheese());
        this.addItem(chilesRellenos);

        Meal breakfastBurritos = new Meal("Breakfast Burritos", 10, new Carb.Tortilla(), new Protein.Chicken(), new Fat.Cheese());
        this.addItem(breakfastBurritos);
    }
}

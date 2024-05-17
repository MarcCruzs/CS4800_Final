package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.food.*;
import com.cppdelivery.utils.*;

public class AmericanRestaurant extends Restaurant {
    public AmericanRestaurant(String name, String address, Counties county, RestaurantOperatingHours operatingHours, double preparationTime) {
        super(name, address, county, operatingHours, preparationTime);
        setCuisine(CuisineTypes.AMERICAN);
    }
    @Override
    protected void setupMenu() {
        Meal cheeseBurger = new Meal("Cheeseburger", 16, new Carb.Bread(), new Protein.Beef(), new Fat.Cheese());
        this.addItem(cheeseBurger);

        Meal friedChicken = new Meal("Fried Chicken", 10, new Carb.Flour(), new Protein.Chicken(), new Fat.OliveOil());
        this.addItem(friedChicken);

        Meal meatLoaf = new Meal("Meatloaf", 14, new Carb.Flour(), new Protein.Beef(), new Fat.Butter());
        this.addItem(meatLoaf);

        Meal chickenSalad = new Meal("Chicken Salad", 14, new Carb.LettuceWrap(), new Protein.Chicken(), new Fat.Almond());
        this.addItem(chickenSalad);
    }
}

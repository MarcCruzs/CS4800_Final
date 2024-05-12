package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.restaurants.food.*;

import java.util.ArrayList;
import java.util.List;

class Menu {
    private List<Meal> meals;

    public Menu() {
        this.meals = new ArrayList<>();
    }

    public void addItem(Meal item) {
        meals.add(item);
    }

    public void showMenu() {
        System.out.println("Menu:");
        meals.forEach(Meal::display);
    }
}
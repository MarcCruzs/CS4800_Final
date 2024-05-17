package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.food.Meal;
import com.cppdelivery.models.food.*;

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

    public Meal getMealByName(String name) {
        for (Meal meal : meals) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null;
    }
    public void showMenu() {
        System.out.println("Menu:");
        meals.forEach(Meal::display);
    }
}
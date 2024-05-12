package com.cppdelivery.models.restaurants;

import com.cppdelivery.models.restaurants.macronutrient.*;

import java.util.ArrayList;
import java.util.List;

class Menu {
    private List<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public void addMeal(MenuItem meal) {
        menuItems.add(meal);
    }

    public void showMenu() {
        System.out.println("Menu:");
        menuItems.forEach(MenuItem::display);
    }
}
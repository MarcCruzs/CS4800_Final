package com.cppdelivery.models.restaurants.food;

public class Meal {
    final private String name;
    final private Carb carb;
    final private Protein protein;
    final private Fat fat;

    // Constructor
    public Meal(String name, Carb carb, Protein protein, Fat fat) {
        this.name = name;
        this.carb = carb;
        this.protein = protein;
        this.fat = fat;
    }
    public String getName() {
        return this.name;
    }

    public Carb getCarb() {
        return this.carb;
    }
    public Protein getProtein() {
        return this.protein;
    }
    public Fat getFat() {
        return this.fat;
    }
    public void display() {
        // Display the name of the dish with a separator
        System.out.println("Name: " + this.name);
        // Display each macronutrient
        System.out.println("Carb: " + carb.getName());
        System.out.println("Protein: " + protein.getName());
        System.out.println("Fat: " + fat.getName());
        System.out.println("--------------------------------");
    }
}

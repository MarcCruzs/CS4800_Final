package com.cppdelivery.models.restaurants.food;

public class Meal implements MealComponent {
    final private String name;
    final private Carb carb;
    final private Protein protein;
    final private Fat fat;
    private double price;
    // Constructor
    public Meal(String name, double price, Carb carb, Protein protein, Fat fat) {
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public void display() {
        // Display the name and price of the dish
        System.out.println("Name: " + this.name);
        System.out.println("Price: $" + this.price);
        // Display each macronutrient
        System.out.println("Carb: " + carb.getName());
        System.out.println("Protein: " + protein.getName());
        System.out.println("Fat: " + fat.getName());
        System.out.println("--------------------------------");
    }
}

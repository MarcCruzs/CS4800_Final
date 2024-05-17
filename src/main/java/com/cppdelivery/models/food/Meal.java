package com.cppdelivery.models.food;

public class Meal implements MealComponent {
    final private String name;
    final private Carb carb;
    final private Protein protein;
    final private Fat fat;
    final private double price;
    public Meal(String name, double price, Carb carb, Protein protein, Fat fat) {
        this.name = name;
        this.price = price;
        this.carb = carb;
        this.protein = protein;
        this.fat = fat;
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
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    public void display() {
        System.out.println("$" + this.price + " " + this.name
                + " [Carb: " + carb.getName()
                + "; Protein: " + protein.getName()
                + "; Fat: " + fat.getName() + "]");
        System.out.println("--------------------------------");
    }
}

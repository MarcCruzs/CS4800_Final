package com.cppdelivery.models.restaurants.macronutrient;

import java.util.List;

public class MenuItem {
    final private String name;
    final private Carb carb;
    private List<Carb> alternativeCarbs;
    final private Protein protein;
    private List<Protein> alternativeProteins;
    final private Fat fat;
    private List<Fat> alternativeFats;

    // Constructor
    public MenuItem(String name, Carb carb, List<Carb> alternativeCarbs, Protein protein, List<Protein> alternativeProteins, Fat fat, List<Fat> alternativeFats) {
        this.name = name;
        this.carb = carb;
        this.alternativeCarbs = alternativeCarbs;
        this.protein = protein;
        this.alternativeProteins = alternativeProteins;
        this.fat = fat;
        this.alternativeFats = alternativeFats;
    }

    // Getter for carb
    public Carb getCarb() {
        return this.carb;
    }

    // Getter for alternative carbs
    public List<Carb> getAlternativeCarbs() {
        return this.alternativeCarbs;
    }

    // Getter for protein
    public Protein getProtein() {
        return this.protein;
    }

    // Getter for alternative proteins
    public List<Protein> getAlternativeProteins() {
        return this.alternativeProteins;
    }

    // Getter for fat
    public Fat getFat() {
        return this.fat;
    }

    // Getter for alternative fats
    public List<Fat> getAlternativeFats() {
        return this.alternativeFats;
    }

    // Method to display the details of the MenuItem
    public void display() {
        System.out.println("Menu Item: " + this.name);
        System.out.println("Ingredients: ");
        carb.getName();
        protein.getName();
        fat.getName();
        System.out.println();
    }
}

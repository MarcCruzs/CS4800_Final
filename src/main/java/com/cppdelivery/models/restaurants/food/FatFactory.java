package com.cppdelivery.models.restaurants.food;

import java.util.concurrent.ThreadLocalRandom;

public class FatFactory {
    private static FatFactory fatFactory;
    private FatFactory(){};

    // Method to get the singleton instance of FatFactory
    public static FatFactory getInstance(){
        if(fatFactory == null){
            fatFactory = new FatFactory();
        }
        return fatFactory;
    }

    // Method to generate a Fat based on the given diet plan
    public Fat createFat(String dietPlan, Fat defaultFat){
        if (dietPlan == null || defaultFat == null) {
            System.out.println("Diet plan or default fat cannot be null.");
            return null;
        }
        switch (dietPlan.toLowerCase()) {
            case "no restriction":
                return defaultFat;
            case "paleo":
                if (defaultFat.getName().equalsIgnoreCase("Pasta")) {
                } else {
                    return defaultFat;
                }
            case "vegan":
                // You may need a specific case for vegan diet
                return defaultFat;
            case "nut allergy":
                // You may need a specific case for nut allergy diet
                return defaultFat;
            default:
                System.out.println("Invalid diet plan.");
                return null;
        }
    }

    // Method to select a random Fat from the given array of choices
    public Fat getRandomFat(Fat[] choices){
        return choices[ThreadLocalRandom.current().nextInt(choices.length)];
    }
}
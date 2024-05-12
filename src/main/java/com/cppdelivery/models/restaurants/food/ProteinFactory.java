package com.cppdelivery.models.restaurants.food;

import java.util.concurrent.ThreadLocalRandom;

public class ProteinFactory {
    private static ProteinFactory proteinFactory;
    private ProteinFactory(){}

    // Method to get the singleton instance of ProteinFactory
    public static ProteinFactory getInstance(){
        if(proteinFactory == null){
            proteinFactory = new ProteinFactory();
        }
        return proteinFactory;
    }

    // Method to generate a Protein based on the given diet plan
    public Protein createProtein(String dietPlan, Protein defaultProtein){
        if (dietPlan == null || defaultProtein == null) {
            System.out.println("Diet plan or default fat cannot be null.");
            return null;
        }
        switch (dietPlan.toLowerCase()) {
            case "no restriction":
                return defaultProtein;
            case "paleo":
                if (defaultProtein.getName().equalsIgnoreCase("Pasta")) {
                } else {
                    return defaultProtein;
                }
            case "vegan":
                // You may need a specific case for vegan diet
                return defaultProtein;
            case "nut allergy":
                // You may need a specific case for nut allergy diet
                return defaultProtein;
            default:
                System.out.println("Invalid diet plan.");
                return null;
        }
    }

    public Protein getRandomProtein(Protein[] choices){
        return choices[ThreadLocalRandom.current().nextInt(choices.length)];
    }
}
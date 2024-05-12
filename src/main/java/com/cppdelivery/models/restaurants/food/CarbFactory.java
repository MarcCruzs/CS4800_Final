package com.cppdelivery.models.restaurants.food;

import java.util.concurrent.ThreadLocalRandom;

public class CarbFactory {
    private static CarbFactory carbFactory;
    private CarbFactory(){}

    // Method to get the singleton instance of CarbFactory
    public static CarbFactory getInstance(){
        if(carbFactory == null){
            carbFactory = new CarbFactory();
        }
        return carbFactory;
    }

    // Method to generate a Carb based on the given diet plan
    public Carb createCarb(String dietPlan, Carb defaultCarb){
        if (dietPlan == null || defaultCarb == null) {
            System.out.println("Diet plan or default carb cannot be null.");
            return null;
        }

        switch (dietPlan.toLowerCase()) {
            case "no restriction":
                return defaultCarb;
            case "paleo":
                if (defaultCarb.getName().equalsIgnoreCase("Pasta")) {
                    return new Carb.ZucchiniNoodles();
                } else {
                    return defaultCarb;
                }
            case "vegan":
                // You may need a specific case for vegan diet
                return defaultCarb;
            case "nut allergy":
                // You may need a specific case for nut allergy diet
                return defaultCarb;
            default:
                System.out.println("Invalid diet plan.");
                return null;
        }
    }

    // Method to select a random Carb from the given array of choices
    public Carb getRandomCarb(Carb[] choices){
        return choices[ThreadLocalRandom.current().nextInt(choices.length)];
    }
}
package com.cppdelivery.models.restaurants.food;

import com.cppdelivery.utils.*;
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
    public Carb createCarb(DietRestrictions dietPlan, Carb defaultCarb){
        if (dietPlan == null || defaultCarb == null) {
            System.out.println("Diet plan or default carb cannot be null.");
            return null;
        }

        switch (dietPlan) {
            case NO_RESTRICTION:
                return defaultCarb;
            case PALEO:
                if (defaultCarb.getName().equalsIgnoreCase("Pasta")) {
                    return new Carb.ZucchiniNoodles();
                }
                if (defaultCarb.getName().equalsIgnoreCase("Rice")) {
                    return new Carb.Quinoa();
                }
                else {
                    return defaultCarb;
                }
            case VEGAN:
                // You may need a specific case for vegan diet
                return defaultCarb;
            case NUT_ALLERGY:
                // You may need a specific case for nut allergy diet
                return defaultCarb;
            default:
                System.out.println("Invalid diet plan.");
                return null;
        }
    }
}
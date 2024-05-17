package com.cppdelivery.models.food;

import com.cppdelivery.utils.*;

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
    public Protein createProtein(DietRestrictions dietPlan, Protein defaultProtein){
        if (dietPlan == null || defaultProtein == null) {
            System.out.println("Diet plan or default protein cannot be null.");
            return null;
        }
        switch (dietPlan) {
            case NO_RESTRICTION:
                return defaultProtein;
            case PALEO:
                if (defaultProtein.getName().equalsIgnoreCase("Tofu")
                ) {
                    return new Protein.Egg();
                } else {
                    return defaultProtein;
                }
            case VEGAN:
                if (defaultProtein.getName().equalsIgnoreCase("Chicken")
                        || defaultProtein.getName().equalsIgnoreCase("Beef")
                        || defaultProtein.getName().equalsIgnoreCase("Egg")
                ) {
                    return new Protein.Tofu();
                } else {
                    return defaultProtein;
                }
            case NUT_ALLERGY:
                return defaultProtein;
            default:
                System.out.println("Invalid diet plan.");
                return null;
        }
    }
}
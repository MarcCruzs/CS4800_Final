package com.cppdelivery.models.food;

import com.cppdelivery.utils.*;

public class FatFactory {
    private static FatFactory fatFactory;
    private FatFactory(){}

    // Method to get the singleton instance of FatFactory
    public static FatFactory getInstance(){
        if(fatFactory == null){
            fatFactory = new FatFactory();
        }
        return fatFactory;
    }

    // Method to generate a Fat based on the given diet plan
    public Fat createFat(DietRestrictions dietPlan, Fat defaultFat){
        if (dietPlan == null || defaultFat == null) {
            System.out.println("Diet plan or default fat cannot be null.");
            return null;
        }
        switch (dietPlan) {
            case NO_RESTRICTION:
                return defaultFat;
            case PALEO:
                if (defaultFat.getName().equalsIgnoreCase("Butter")) { 
                    return new Fat.OliveOil();
                }
                if (defaultFat.getName().equalsIgnoreCase("Cheese")) {
                    return new Fat.NutritionalYeast();
                } else {
                    return defaultFat;
                }
            case VEGAN:
                if (defaultFat.getName().equalsIgnoreCase("Butter")) {
                    return new Fat.OliveOil();
                }
                if (defaultFat.getName().equalsIgnoreCase("Cheese")) {
                    return new Fat.NutritionalYeast();
                } else {
                    return defaultFat;
                }
            case NUT_ALLERGY:
                if (defaultFat.getName().equalsIgnoreCase("Almond")) {
                    return new Fat.PumpkinSeed();
                } else {
                    return defaultFat;
                }
            default:
                System.out.println("Invalid diet plan.");
                return null;
        }
    }

}
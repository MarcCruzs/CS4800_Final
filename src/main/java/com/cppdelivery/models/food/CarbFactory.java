package com.cppdelivery.models.food;

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
                if (defaultCarb.getName().equalsIgnoreCase("Bread") || defaultCarb.getName().equalsIgnoreCase("Tortilla")) {
                    return new Carb.LettuceWrap();
                }
                if (defaultCarb.getName().equalsIgnoreCase("Flour")) {
                    return new Carb.GlutenFreeFlour();
                }
                else {
                    return defaultCarb;
                }
            case VEGAN:
                if (defaultCarb.getName().equalsIgnoreCase("Pasta")) {
                    return new Carb.ZucchiniNoodles();
                }
                else {
                    return defaultCarb;
                }
            case NUT_ALLERGY:
                return defaultCarb;
            default:
                System.out.println("Invalid diet plan.");
                return null;
        }
    }
}
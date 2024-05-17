package com.cppdelivery.models.food;

import com.cppdelivery.utils.*;
import com.cppdelivery.models.food.toppings.*;

import java.util.List;

public class MacronutrientFactory {
    private static MacronutrientFactory factory = null;
    private MacronutrientFactory(){}

    public static MacronutrientFactory getInstance() {
        if (factory == null)
            factory = new MacronutrientFactory();
        return factory;
    }

    public Meal makeMeal(Meal meal, DietRestrictions dietPlan, List<String> toppings) {
        CarbFactory carbFactory = CarbFactory.getInstance();
        ProteinFactory proteinFactory = ProteinFactory.getInstance();
        FatFactory fatFactory = FatFactory.getInstance();

        Carb carb = carbFactory.createCarb(dietPlan, meal.getCarb());
        Protein protein = proteinFactory.createProtein(dietPlan, meal.getProtein());
        Fat fat = fatFactory.createFat(dietPlan, meal.getFat());

        Meal basicMeal = new Meal(meal.getName() + " " + dietPlan, meal.getPrice(), carb, protein, fat);

        // Decorate the meal with toppings
        for (String topping : toppings) {
            switch (topping.toLowerCase()) {
                case "truffle oil":
                    basicMeal = new TruffleOilTopping(basicMeal);
                    break;
                case "avocado":
                    basicMeal = new AvocadoTopping(basicMeal);
                    break;
                case "caramelized onion":
                    basicMeal = new CaramelizedOnionTopping(basicMeal);
                    break;
            }
        }

        return basicMeal;
    }
}

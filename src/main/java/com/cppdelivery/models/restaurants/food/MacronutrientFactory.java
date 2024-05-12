package com.cppdelivery.models.restaurants.food;

import java.util.List;

public class MacronutrientFactory {
    private static MacronutrientFactory factory = null;
    private MacronutrientFactory(){}

    public static MacronutrientFactory getInstance() {
        if (factory == null)
            factory = new MacronutrientFactory();
        return factory;
    }

    public Meal makeMeal(Meal meal, String dietPlan, List<String> toppings) {
        CarbFactory carbFactory = CarbFactory.getInstance();
        ProteinFactory proteinFactory = ProteinFactory.getInstance();
        FatFactory fatFactory = FatFactory.getInstance();

        Carb carb = carbFactory.createCarb(dietPlan, meal.getCarb());
        Protein protein = proteinFactory.createProtein(dietPlan, meal.getProtein());
        Fat fat = fatFactory.createFat(dietPlan, meal.getFat());

        Meal basicMeal = new Meal(meal.getName() + " " + dietPlan, meal.getPrice(), carb, protein, fat);

        // Decorate the meal with toppings by modifying the name
        for (String topping : toppings) {
            switch (topping.toLowerCase()) {
                case "truffle oil":
                    basicMeal = new TruffleOilTopping(basicMeal);
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

package com.cppdelivery.models.restaurants.food;

public class MacronutrientFactory {
    private static MacronutrientFactory factory = null;
    private MacronutrientFactory(){}

    public static MacronutrientFactory getInstance() {
        if (factory == null)
            factory = new MacronutrientFactory();
        return factory;
    }

    public Meal makeMeal(Meal meal, String dietPlan) {
        CarbFactory carbFactory = CarbFactory.getInstance();
        ProteinFactory proteinFactory = ProteinFactory.getInstance();
        FatFactory fatFactory = FatFactory.getInstance();

        Carb carb = carbFactory.createCarb(dietPlan, meal.getCarb());
        Protein protein = proteinFactory.createProtein(dietPlan, meal.getProtein());
        Fat fat = fatFactory.createFat(dietPlan, meal.getFat());

        return new Meal(meal.getName() + " " + dietPlan,carb, protein, fat);
    }
}

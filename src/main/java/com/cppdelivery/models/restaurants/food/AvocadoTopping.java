package com.cppdelivery.models.restaurants.food;

public class AvocadoTopping extends MealDecorator {
    private static final double AVOCADO_PRICE = 4.00;
    public AvocadoTopping(Meal decoratedMeal) {
        super(decoratedMeal);
    }

    @Override
    public String getName() {
        return decoratedMeal.getName() + ", added Avocado (+$4.00)";
    }
    @Override
    public double getPrice() {
        return super.getPrice() + AVOCADO_PRICE;
    }
}

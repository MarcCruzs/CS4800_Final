package com.cppdelivery.models.restaurants.food;

public class CaramelizedOnionTopping extends MealDecorator {
    private static final double CARAMELIZED_ONION_PRICE = 2.00;

    public CaramelizedOnionTopping(Meal decoratedMeal) {
        super(decoratedMeal);
    }

    @Override
    public String getName() {
        return decoratedMeal.getName() + ", added Caramelized Onion (+$2.00)";
    }
    @Override
    public double getPrice() {
        return super.getPrice() + CARAMELIZED_ONION_PRICE;
    }
}
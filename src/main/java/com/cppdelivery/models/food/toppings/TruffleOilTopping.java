package com.cppdelivery.models.food.toppings;

import com.cppdelivery.models.food.Meal;

public class TruffleOilTopping extends MealDecorator {
    private static final double TRUFFLE_OIL_PRICE = 3.00;

    public TruffleOilTopping(Meal decoratedMeal) {
        super(decoratedMeal);
    }

    @Override
    public String getName() {
        return decoratedMeal.getName() + ", added Truffle Oil (+$3.00)";
    }
    @Override
    public double getPrice() {
        return super.getPrice() + TRUFFLE_OIL_PRICE;
    }
}

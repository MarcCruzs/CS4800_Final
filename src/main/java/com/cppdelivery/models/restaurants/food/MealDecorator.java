package com.cppdelivery.models.restaurants.food;

public abstract class MealDecorator extends Meal {
    protected Meal decoratedMeal;

    public MealDecorator(Meal decoratedMeal) {
        super(decoratedMeal.getName(), decoratedMeal.getPrice(), decoratedMeal.getCarb(), decoratedMeal.getProtein(), decoratedMeal.getFat());
        this.decoratedMeal = decoratedMeal;
    }
    @Override
    public String getName() {
        return decoratedMeal.getName();
    }
    @Override
    public double getPrice() {
        return decoratedMeal.getPrice();
    }
}

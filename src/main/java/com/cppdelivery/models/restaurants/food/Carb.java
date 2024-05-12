package com.cppdelivery.models.restaurants.food;

public abstract class Carb {
    public abstract String getName();
    public static class Pasta extends Carb {
        @Override
        public String getName() {
            return "Pasta";
        }
    }
    public static class ZucchiniNoodles extends Carb {
        @Override
        public String getName() {
            return "Zucchini Noodles";
        }
    }
}

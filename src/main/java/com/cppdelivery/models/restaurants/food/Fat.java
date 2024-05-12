package com.cppdelivery.models.restaurants.food;

public abstract class Fat {
    public abstract String getName();

    public static class Avocado extends Fat {
        @Override
        public String getName() {
            return "Avocado";
        }
    }

    public static class OliveOil extends Fat {
        @Override
        public String getName() {
            return "Olive Oil";
        }
    }
}
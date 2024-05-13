package com.cppdelivery.models.restaurants.food;

public abstract class Fat {
    public abstract String getName();

    public static class Butter extends Fat {
        @Override
        public String getName() {
            return "Butter";
        }
    }

    public static class OliveOil extends Fat {
        @Override
        public String getName() {
            return "Olive Oil";
        }
    }
}
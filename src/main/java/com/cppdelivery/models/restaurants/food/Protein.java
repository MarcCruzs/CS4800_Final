package com.cppdelivery.models.restaurants.food;

public abstract class Protein {
    public abstract String getName();


    public static class Chicken extends Protein {
        @Override
        public String getName() {
            return "Chicken";
        }
    }

    public static class Beef extends Protein {
        @Override
        public String getName() {
            return "Beef";
        }
    }
    public static class Lentils extends Protein {
        @Override
        public String getName() {
            return "Lentils";
        }
    }
}
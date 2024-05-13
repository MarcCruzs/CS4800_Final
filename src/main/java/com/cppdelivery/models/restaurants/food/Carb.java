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
    public static class Rice extends Carb {
        @Override
        public String getName() {
            return "Rice";
        }
    }
    public static class Quinoa extends Carb {
        @Override
        public String getName() {
            return "Quinoa";
        }
    }
    public static class Bread extends Carb {
        @Override
        public String getName() {
            return "Bread";
        }
    }
}

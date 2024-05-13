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
    public static class Egg extends Protein {
        @Override
        public String getName() {
            return "Egg";
        }
    }
    // vegan alternative for meat
    public static class Tofu extends Protein {
        @Override
        public String getName() {
            return "Tofu";
        }
    }
}

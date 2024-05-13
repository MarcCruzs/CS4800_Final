package com.cppdelivery.models.restaurants.food;

public abstract class Fat {
    public abstract String getName();

    // Not paleo and vegan friendly
    public static class Butter extends Fat {
        @Override
        public String getName() {
            return "Butter";
        }
    }
    // Paleo vegan alternative for butter
    public static class OliveOil extends Fat {
        @Override
        public String getName() {
            return "Olive Oil";
        }
    }
    // Not paleo and vegan friendly
    public static class Cheese extends Fat {
        @Override
        public String getName() {
            return "Cheese";
        }
    }
    // Paleo vegan alternative for cheese
    public static class NutritionalYeast extends Fat {
        @Override
        public String getName() {
            return "Nutritional Yeast";
        }
    }
    // Not nut allergy friendly
    public static class Almond extends Fat {
        @Override
        public String getName() {
            return "Almond";
        }
    }
    // nut allergy alternative for almond
    public static class PumpkinSeed extends Fat {
        @Override
        public String getName() {
            return "Pumpkin Seed";
        }
    }
    // Not nut allergy friendly
    public static class Pesto extends Fat {
        @Override
        public String getName() {
            return "Pesto";
        }
    }
    // nut allergy alternative for almond
    public static class SunflowerSeedPesto extends Fat {
        @Override
        public String getName() {
            return "Sunflower Seed Pesto";
        }
    }
}
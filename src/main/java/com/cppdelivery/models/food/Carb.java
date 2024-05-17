package com.cppdelivery.models.food;

public abstract class Carb {
    public abstract String getName();
    // Not paleo, vegan friendly
    public static class Pasta extends Carb {
        @Override
        public String getName() {
            return "Pasta";
        }
    }
    // Paleo vegan alternative for pasta
    public static class ZucchiniNoodles extends Carb {
        @Override
        public String getName() {
            return "Zucchini Noodles";
        }
    }
    // Not paleo friendly
    public static class Rice extends Carb {
        @Override
        public String getName() {
            return "Rice";
        }
    }
    // Paleo alternative for rice
    public static class Quinoa extends Carb {
        @Override
        public String getName() {
            return "Quinoa";
        }
    }
    // Not paleo friendly
    public static class Bread extends Carb {
        @Override
        public String getName() {
            return "Bread";
        }
    }
    // Not paleo friendly
    public static class Tortilla extends Carb {
        @Override
        public String getName() {
            return "Tortilla";
        }
    }
    // Paleo alternative for bread and tortilla
    public static class LettuceWrap extends Carb {
        @Override
        public String getName() {
            return "Lettuce Wrap";
        }
    }
    // Not paleo friendly
    public static class Flour extends Carb {
        @Override
        public String getName() {
            return "Flour";
        }
    }
    // Paleo alternative for flour
    public static class GlutenFreeFlour extends Carb {
        @Override
        public String getName() {
            return "Gluten-free Flour";
        }
    }
}

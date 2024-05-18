package com.cppdelivery.testcases;

import com.cppdelivery.models.food.toppings.TruffleOilTopping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.cppdelivery.models.food.*;
import com.cppdelivery.utils.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MacronutrientFactoryTest {
    private MacronutrientFactory macronutrientFactory;

    @BeforeEach
    void setUp() {
        macronutrientFactory = MacronutrientFactory.getInstance();
    }

    @Test
    void testSingletonInstance() {
        MacronutrientFactory factory1 = MacronutrientFactory.getInstance();
        MacronutrientFactory factory2 = MacronutrientFactory.getInstance();
        assertSame(factory1, factory2);
    }

    @Test
    void testMakeMealWithoutDietRestrictions() {
        Meal meal = new Meal("Pasta", 30.0, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        DietRestrictions dietPlan = DietRestrictions.NO_RESTRICTION;
        List<String> toppings = new ArrayList<>();
        toppings.add("truffle oil");

        Meal preparedMeal = macronutrientFactory.makeMeal(meal, dietPlan, toppings);
        assertEquals("Pasta " + dietPlan + ", added Truffle Oil (+$3.00)", preparedMeal.getName());
        assertEquals(33.0, preparedMeal.getPrice());
        assertTrue(preparedMeal instanceof TruffleOilTopping);
    }

    @Test
    void testMakeMealWithDietRestrictions() {
        Meal meal = new Meal("Pasta", 30.0, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        DietRestrictions dietPlan = DietRestrictions.VEGAN;
        List<String> toppings = new ArrayList<>();
        toppings.add("avocado");
        toppings.add("caramelized onion");

        Meal preparedMeal = macronutrientFactory.makeMeal(meal, dietPlan, toppings);
        assertEquals("Pasta " + dietPlan + ", added Avocado (+$4.00), added Caramelized Onion (+$2.00)", preparedMeal.getName());
        assertEquals(36.0, preparedMeal.getPrice());
    }

    @Test
    void testMakeMealWithUnknownTopping() {
        Meal meal = new Meal("Pasta", 30.0, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        DietRestrictions dietPlan = DietRestrictions.NO_RESTRICTION;
        List<String> toppings = new ArrayList<>();
        toppings.add("unknown topping");

        Meal preparedMeal = macronutrientFactory.makeMeal(meal, dietPlan, toppings);
        assertEquals("Pasta " + dietPlan, preparedMeal.getName());
        assertEquals(30.0, preparedMeal.getPrice());
    }
}


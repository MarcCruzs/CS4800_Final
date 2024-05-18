package com.cppdelivery.testcases;

import com.cppdelivery.models.*;
import com.cppdelivery.models.food.*;
import com.cppdelivery.models.restaurants.*;
import com.cppdelivery.utils.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class OrderTest {
    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;
    private Order order;
    private MacronutrientFactory macronutrientFactory;

    @BeforeEach
    void setUp() {
        driver = new Driver("John Doe", "123 Elm Street", 30.0, Counties.LA, DriverTimeShifts.FIRST_SHIFT);
        customer = new Customer("Jane Doe", "456 Oak Street", Counties.LA, DietRestrictions.NO_RESTRICTION);
        restaurant = new ItalianRestaurant("Pizza Place", "5339 2nd Street", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT, 20.0);
        order = new Order(restaurant, customer, driver, "10:00 AM");
        macronutrientFactory = MacronutrientFactory.getInstance();
    }

    @Test
    void testOrderCreation() {
        assertEquals("Pizza Place", order.getRestaurant().getName());
        assertEquals("Jane Doe", order.getCustomer().getCustomerName());
        assertEquals("John Doe", order.getDriver().getName());
        assertEquals("10:00 AM", order.getOrderCreationTime());
        assertTrue(order.getFoodItemList().isEmpty());
    }

    @Test
    void testAddMealByName() {
        List<String> toppings = Arrays.asList("Truffle Oil", "Avocado");
        order.addMealByName("Bolognese Pasta", toppings);
        assertEquals(1, order.getFoodItemList().size());
        assertEquals("Bolognese Pasta No restriction, added Truffle Oil (+$3.00), added Avocado (+$4.00)", order.getFoodItemList().get(0).getName());
    }

    @Test
    void testAddMealByNameNotFound() {
        order.addMealByName("Pizza", new ArrayList<>());
        assertTrue(order.getFoodItemList().isEmpty());
    }

    @Test
    void testGetTotalPrice() {
        Meal meal1 = new Meal("Pasta", 30.0, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        Meal meal2 = new Meal("Chicken Rice", 5.0, new Carb.Rice(), new Protein.Chicken(), new Fat.OliveOil());
        restaurant.addItem(meal1);
        restaurant.addItem(meal2);
        order.addMealByName("Pasta", new ArrayList<>());
        order.addMealByName("Chicken Rice", new ArrayList<>());
        assertEquals(35.0, order.getTotalPrice());
    }

    @Test
    void testOrderPickUpAndDeliveryTimes() {
        assertEquals("Not picked up yet", order.getOrderPickUpTimeString());
        assertEquals("Not delivered up yet", order.getOrderDeliveredTimeString());
        order.setOrderPickUpTime("12:30 PM");
        order.setOrderDeliveredTime("01:30 PM");
        assertEquals("12:30 PM", order.getOrderPickUpTimeString());
        assertEquals("01:30 PM", order.getOrderDeliveredTimeString());
    }
}

package com.cppdelivery.testcases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.cppdelivery.models.*;
import com.cppdelivery.services.*;
import com.cppdelivery.models.food.*;
import com.cppdelivery.models.restaurants.*;
import com.cppdelivery.utils.*;

class RestaurantTest {
    private Restaurant restaurant;
    private Counties county;
    private RestaurantOperatingHours operatingHours;
    private DeliveryServices deliveryServices;

    @BeforeEach
    void setUp() {
        county = Counties.LA;
        operatingHours = RestaurantOperatingHours.FIRST_SHIFT;
        restaurant = new Restaurant("Test Restaurant", "123 Test St", county, operatingHours, 30.0);
        deliveryServices = DeliveryServices.getInstance();
    }

    @Test
    void testRestaurantCreation() {
        assertEquals("Test Restaurant", restaurant.getName());
        assertEquals("123 Test St", restaurant.getAddress());
        assertEquals(county, restaurant.getCounty());
        assertEquals(operatingHours, restaurant.getOperatingHours());
        assertEquals(30.0, restaurant.getPreparationTime());
    }

    @Test
    void testAddItemToMenu() {
        Meal meal = new Meal("Pasta", 30.0, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        restaurant.addItem(meal);
        Meal retrievedMeal = restaurant.getMealByName("Pasta");
        assertNotNull(retrievedMeal);
        assertEquals("Pasta", retrievedMeal.getName());
        assertEquals(30.0, retrievedMeal.getPrice());
    }

    @Test
    void testGetMealByName() {
        Meal meal1 = new Meal("Pasta", 30.0, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        Meal meal2 = new Meal("Chicken Rice", 5.0, new Carb.Rice(), new Protein.Chicken(), new Fat.OliveOil());
        restaurant.addItem(meal1);
        restaurant.addItem(meal2);
        Meal retrievedMeal = restaurant.getMealByName("Chicken Rice");
        assertNotNull(retrievedMeal);
        assertEquals("Chicken Rice", retrievedMeal.getName());
        assertEquals(5.0, retrievedMeal.getPrice());
    }

    @Test
    void testGetMealByNameNotFound() {
        Meal meal = restaurant.getMealByName("Pizza");
        assertNull(meal);
    }

    @Test
    void testIsRestaurantAvailable() {
        assertTrue(restaurant.isRestaurantAvailable("10:00 AM"));
        assertTrue(restaurant.isRestaurantAvailable("08:00 AM"));
        assertFalse(restaurant.isRestaurantAvailable("10:00 PM"));
    }

    @Test
    void testRegisterRestaurant() {
        restaurant.register();
        Restaurant registeredRestaurant = deliveryServices.findRegisteredRestaurant("Test Restaurant");
        assertNotNull(registeredRestaurant);
        assertEquals("Test Restaurant", registeredRestaurant.getName());
    }
}


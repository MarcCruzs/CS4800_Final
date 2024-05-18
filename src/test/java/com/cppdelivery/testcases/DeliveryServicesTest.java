package com.cppdelivery.testcases;

import com.cppdelivery.models.*;
import com.cppdelivery.models.food.*;
import com.cppdelivery.models.restaurants.Restaurant;
import com.cppdelivery.services.*;
import com.cppdelivery.utils.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryServicesTest {

    private DeliveryServices deliveryServices;
    private Driver driver;
    private Customer customer;
    private Restaurant restaurant;
    private Order order;
    OrderBuilder orderBuilder = new OrderBuilder();
    OrderServices orderServices = new OrderServices(orderBuilder);
    MacronutrientFactory factory = MacronutrientFactory.getInstance();

    @BeforeEach
    void setUp() {
        deliveryServices = DeliveryServices.getInstance();
        driver = new Driver("John Doe", "123 Elm Street", 30.0, Counties.LA, DriverTimeShifts.FIRST_SHIFT);
        customer = new Customer("Jane Doe", "456 Oak Street", Counties.LA, DietRestrictions.NO_RESTRICTION);
        restaurant = new Restaurant("Pizza Place", "5339 2nd Street", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT, 20.0);
    }

    @Test
    void getInstance() {
        DeliveryServices instance = DeliveryServices.getInstance();
        assertNotNull(instance);
        assertSame(instance, deliveryServices);
    }

    @Test
    void registerDriver() {
        deliveryServices.registerDriver(driver);
        assertTrue(deliveryServices.isDriverRegistered(driver));
    }

    @Test
    void registerCustomer() {
        deliveryServices.registerCustomer(customer);
        assertTrue(deliveryServices.isCustomerRegistered(customer));
    }

    @Test
    void registerRestaurant() {
        deliveryServices.registerRestaurant(restaurant);
        assertTrue(deliveryServices.isRestaurantRegistered(restaurant));
    }

    @Test
    void placeOrder() {
        deliveryServices.registerCustomer(customer);
        deliveryServices.registerDriver(driver);
        deliveryServices.registerRestaurant(restaurant);

        List<Meal> foodItems = new ArrayList<>();
        Meal pastaBolognese = new Meal("Pasta Bolognese", 20, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        List<String> toppings = Arrays.asList("Truffle Oil", "Avocado");
        Meal cookedPastaBolognese = factory.makeMeal(pastaBolognese, customer.getcustomerDietaryRestriction(), toppings);
        foodItems.add(cookedPastaBolognese);

        order = orderServices.buildOrder(restaurant, customer, driver, foodItems,"08:00 AM");
        deliveryServices.placeOrder(order, "Pizza Place");

        assertNotNull(order.getDriver());
        assertNotNull(order.getRestaurant());
    }

    @Test
    void checkOrder() {
        Driver wrongDriver = new Driver("John Doe", "123 Elm Street", 30.0, Counties.SAN_BERNARDINO, DriverTimeShifts.FIRST_SHIFT);

        List<Meal> foodItems = new ArrayList<>();
        Meal pastaBolognese = new Meal("Pasta Bolognese", 20, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        List<String> toppings = Arrays.asList("Truffle Oil", "Avocado");
        Meal cookedPastaBolognese = factory.makeMeal(pastaBolognese, customer.getcustomerDietaryRestriction(), toppings);
        foodItems.add(cookedPastaBolognese);

        deliveryServices.registerDriver(wrongDriver);
        deliveryServices.registerDriver(driver);
        deliveryServices.registerRestaurant(restaurant);

        order = orderServices.buildOrder(restaurant, customer, wrongDriver, foodItems,"08:00 AM");

        Order checkedOrder = deliveryServices.checkOrder(order);
        assertNotNull(checkedOrder);
        assertEquals(driver.getName(), checkedOrder.getDriver().getName());
        assertEquals(restaurant, checkedOrder.getRestaurant());
    }

    @Test
    void findRegisteredRestaurant() {
        deliveryServices.registerRestaurant(restaurant);
        Restaurant foundRestaurant = deliveryServices.findRegisteredRestaurant(restaurant.getName());
        assertNotNull(foundRestaurant);
        assertEquals(restaurant, foundRestaurant);
    }

    @Test
    void isCustomerRegistered() {
        deliveryServices.registerCustomer(customer);
        assertTrue(deliveryServices.isCustomerRegistered(customer));
    }

    @Test
    void isDriverRegistered() {
        deliveryServices.registerDriver(driver);
        assertTrue(deliveryServices.isDriverRegistered(driver));
    }

    @Test
    void isRestaurantRegistered() {
        deliveryServices.registerRestaurant(restaurant);
        assertTrue(deliveryServices.isRestaurantRegistered(restaurant));
    }
}

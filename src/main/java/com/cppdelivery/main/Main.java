package com.cppdelivery.main;
import com.cppdelivery.models.*;
import com.cppdelivery.services.DeliveryServices;
import com.cppdelivery.services.OrderServices;
import com.cppdelivery.utils.*;
import com.cppdelivery.models.restaurants.*;
import com.cppdelivery.models.restaurants.food.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Factory to make meals
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        // Order Builder
        OrderBuilder orderBuilder = new OrderBuilder();
        OrderServices orderServices = new OrderServices(orderBuilder);

        //DeliveryService
        DeliveryServices CPPDelivery = DeliveryServices.getInstance();

        // Create a restaurant
        Restaurant restaurant = new ItalianRestaurant("Domenico", "5339 2nd Street", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT, 40);
        restaurant.register();

        // Create a customer
        Customer customer = new Customer("John Doe", "123 Main St", Counties.LA, DietRestrictions.PALEO);
        customer.register();

        // Create a driver
        Driver driver = new Driver("George", "456 That Place", 15, Counties.LA, DriverTimeShifts.FIRST_SHIFT);
        driver.register();

        // Prepare food items list
        List<Meal> foodItems = new ArrayList<>();
        Meal pastaBolognese = new Meal("Pasta Bolognese", 40, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        List<String> toppings = Arrays.asList("Truffle Oil");
        Meal cookedPastaBolognese = factory.makeMeal(pastaBolognese, customer.getcustomerDietaryRestriction(), toppings);
        foodItems.add(cookedPastaBolognese);
        // Add more food items as needed

        // Place the order
        Order order = orderServices.placeOrder(restaurant, customer, driver, foodItems, "08:00 AM");
        CPPDelivery.placeOrder(order, "Domenico");

        // Display Order Detail
        System.out.println("\nOrder placed successfully!");
        System.out.println("*** Order Summary ***");
        System.out.printf("Restaurant: %s\n", order.getRestaurant().getName());
        System.out.printf("Customer: %s\n", order.getCustomer().getCustomerName());
        System.out.printf("Order Creation Time: %s\n", order.getOrderCreationTimeString());
        System.out.printf("Total Price: %.2f\n", order.getTotalPrice()); // Assuming the price is a double
        System.out.println("Items in order:");
        order.displayFoodItems();


        System.out.println("\n*** Delivery Detail ***");
        System.out.printf("Driver: %s\n", order.getDriver().getName()); // Corrected to getDriverName()
        System.out.printf("Delivery Address: %s\n", order.getCustomer().getCustomerAddress());
        System.out.printf("Order Pick Up Time: %s\n", order.getOrderPickUpTimeString());
        System.out.printf("Order Deliver Time: %s\n", order.getOrderDeliveredTimeString());
    }
}
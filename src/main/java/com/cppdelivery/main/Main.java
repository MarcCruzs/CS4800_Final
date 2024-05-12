package com.cppdelivery.main;
import com.cppdelivery.models.*;
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

        // Testing factory
        Meal pastaBolognese = new Meal("Pasta Bolognese", 40, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        List<String> toppings = Arrays.asList("Truffle Oil");
        Meal cookedPastaBolognese = factory.makeMeal(pastaBolognese, "Paleo", toppings);
        cookedPastaBolognese.display();


        // Order Builder
        OrderBuilder orderBuilder = new OrderBuilder();
        OrderServices orderServices = new OrderServices(orderBuilder);

        // Create a restaurant
        Restaurant restaurant = new ItalianRestaurant("Domenico", "5339 2nd Street", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT);

        // Create a customer
        Customer customer = new Customer("John Doe", "123 Main St", Counties.LA, DietRestrictions.PALEO);

        // Create a driver
        Driver driver = new Driver(/* Driver details */);

        // Prepare food items list
        List<Meal> foodItems = new ArrayList<>();
        foodItems.add(cookedPastaBolognese);
        // Add more food items as needed

        // Place the order
        Order order = orderServices.placeOrder(restaurant, customer, driver, foodItems);

        // Display Order Detail
        // Change to order.getRestaurant().getRestautantName()
        System.out.println("\nOrder placed successfully!");
        System.out.println("*** Order Summary *** \nRestaurant: " + order.getRestaurant() +
                "\nCustomer: " + order.getCustomer().getCustomerName() +
                "\nOrder Creation Time: " + order.getOrderCreationTimeString());
        System.out.println("\nItems in order:");
        order.displayFoodItems();
        // Change to order.getDriver().getDriverName()
        System.out.println("\n*** Delivery Detail ***:\nDriver: " + order.getDriver() +
                "\nDelivery Address: " + order.getCustomer().getCustomerAddress() +
                "\nOrder Pick Up Time: " + order.getOrderPickUpTimeString() +
                "\nOrder Deliver Time: " + order.getOrderDeliveredTimeString());
    }
}
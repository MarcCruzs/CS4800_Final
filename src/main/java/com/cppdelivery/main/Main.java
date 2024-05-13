package com.cppdelivery.main;
import com.cppdelivery.models.*;
import com.cppdelivery.services.OrderServices;
import com.cppdelivery.utils.*;
import com.cppdelivery.models.restaurants.*;
import com.cppdelivery.models.restaurants.food.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Testing factory, restaurant creation, meals
        MacronutrientFactory factory = MacronutrientFactory.getInstance();
        Restaurant domenicoRestaurant = new ItalianRestaurant("Domenico", "5339 2nd Street", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT);
        domenicoRestaurant.showDetails();
//        Meal pastaBolognese = new Meal("Pasta Bolognese", new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
//        Meal test = factory.makeMeal(pastaBolognese, "Paleo");
//        test.display();

        // Testing driver shift
        DriverTimeShifts shift1 = DriverTimeShifts.FIRST_SHIFT;
        DriverTimeShifts shift2 = DriverTimeShifts.SECOND_SHIFT;
        DriverTimeShifts shift3 = DriverTimeShifts.THIRD_SHIFT;

        System.out.println("Shift 1: " + shift1); // Output: Shift 1: FIRST SHIFT
        System.out.println("Shift 2: " + shift2); // Output: Shift 2: SECOND SHIFT
        System.out.println("Shift 3: " + shift3); // Output: Shift 3: THIRD SHIFT

        // Accessing timing
        System.out.println("Shift 1 Timing: " + shift1.getStartTime() + " - " + shift1.getEndTime()); // Output: Shift 1 Timing: 8:00 AM - 4:00 PM
        System.out.println("Shift 2 Timing: " + shift2.getStartTime() + " - " + shift2.getEndTime()); // Output: Shift 2 Timing: 4:00 PM - 12:00 AM
        System.out.println("Shift 3 Timing: " + shift3.getStartTime() + " - " + shift3.getEndTime()); // Output: Shift 3 Timing: 12:00 AM - 8:00 AM

        // Order Builder
        OrderBuilder orderBuilder = new OrderBuilder();
        OrderServices orderServices = new OrderServices(orderBuilder);

        // Create a restaurant
        Restaurant restaurant = new Restaurant("Domenico", "5339 2nd Street", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT);

        // Create a customer
        Customer customer = new Customer("John Doe", "123 Main St", Counties.LA, DietRestrictions.NUT_ALLERGY);

        // Create a driver
        Driver driver = new Driver(/* Driver details */);

//        // Prepare food items list
         List<Meal> foodItems = new ArrayList<>();
//        foodItems.add("Pizza");
//        foodItems.add("Burger");
        // Add more food items as needed

        // Place the order
        Order order = orderServices.placeOrder(restaurant, customer, driver, foodItems);

        // Display Order Detail
        // Change to order.getRestaurant().getRestautantName()
        System.out.println("\nOrder placed successfully!");
        System.out.println("*** Order Summary *** \nRestaurant: " + order.getRestaurant() +
                "\nCustomer: " + order.getCustomer().getCustomerName() +
                "\nFood Order: " + order.getFoodItemList() +
                "\nOrder Creation Time: " + order.getOrderCreationTimeString());
        // Change to order.getDriver().getDriverName()
        System.out.println("\n*** Delivery Detail ***:\nDriver: " + order.getDriver() +
                "\nDelivery Address: " + order.getCustomer().getCustomerAddress() +
                "\nOrder Pick Up Time: " + order.getOrderPickUpTimeString() +
                "\nOrder Deliver Time: " + order.getOrderDeliveredTimeString());
    }
}
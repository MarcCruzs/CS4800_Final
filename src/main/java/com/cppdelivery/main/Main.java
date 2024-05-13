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

        // Order Builder
        OrderBuilder orderBuilder = new OrderBuilder();
        OrderServices orderServices = new OrderServices(orderBuilder);

        // Create 4 restaurant
        Restaurant restaurant_1 = new ItalianRestaurant("Domenico", "5339 2nd St", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT);
        Restaurant restaurant_2 = new AsianRestaurant("Dragon House", "99821 Hobart St", Counties.ORANGE, RestaurantOperatingHours.FIRST_SHIFT);
        Restaurant restaurant_3 = new AmericanRestaurant("AJ Burger", "43123 Bernard St", Counties.ORANGE, RestaurantOperatingHours.SECOND_SHIFT);
        Restaurant restaurant_4 = new MexicanRestaurant("Senior Sol", "12342 5th St", Counties.SAN_BERNARDINO, RestaurantOperatingHours.THIRD_SHIFT);

        // Create 8 driver
        Driver driver_1 = new Driver("Alice", "123 Main St", 10, Counties.LA, DriverTimeShifts.FIRST_SHIFT);
        Driver driver_2 = new Driver("Bob", "456 Flower St", 15, Counties.LA, DriverTimeShifts.SECOND_SHIFT);
        Driver driver_3 = new Driver("Charlie", "789 Well St", 20, Counties.LA, DriverTimeShifts.THIRD_SHIFT);
        Driver driver_4 = new Driver("David", "102 Balboa St", 12, Counties.ORANGE, DriverTimeShifts.FIRST_SHIFT);
        Driver driver_5 = new Driver("Emily", "293 Goods St", 15, Counties.ORANGE, DriverTimeShifts.SECOND_SHIFT);
        Driver driver_6 = new Driver("Fang", "384 3rd St", 25, Counties.ORANGE, DriverTimeShifts.THIRD_SHIFT);
        Driver driver_7 = new Driver("George", "475 Peace St", 20, Counties.SAN_BERNARDINO, DriverTimeShifts.SECOND_SHIFT);
        Driver driver_8 = new Driver("Han", "565 Red St", 30, Counties.SAN_BERNARDINO, DriverTimeShifts.THIRD_SHIFT);

        // Create 10 customer
        Customer customer_1 = new Customer("Zach A.", "123 Main St", Counties.LA, DietRestrictions.PALEO);
        Customer customer_2 = new Customer("Yama B.", "123 Main St", Counties.LA, DietRestrictions.PALEO);
        Customer customer_3 = new Customer("Xaiver C.", "123 Main St", Counties.LA, DietRestrictions.PALEO);
        Customer customer_4 = new Customer("Willow D.", "123 Main St", Counties.LA, DietRestrictions.PALEO);
        Customer customer_5 = new Customer("Violent E.", "123 Main St", Counties.ORANGE, DietRestrictions.PALEO);
        Customer customer_6 = new Customer("Unicorn F.", "123 Main St", Counties.ORANGE, DietRestrictions.PALEO);
        Customer customer_7 = new Customer("Tiffany G.", "123 Main St", Counties.ORANGE, DietRestrictions.PALEO);
        Customer customer_8 = new Customer("Sky H.", "123 Main St", Counties.SAN_BERNARDINO, DietRestrictions.PALEO);
        Customer customer_9 = new Customer("Ryan E.", "123 Main St", Counties.SAN_BERNARDINO, DietRestrictions.PALEO);
        Customer customer_10 = new Customer("Queen B.", "123 Main St", Counties.SAN_BERNARDINO, DietRestrictions.PALEO);


        // Prepare food items list
        List<Meal> foodItems = new ArrayList<>();
        Meal pastaBolognese = new Meal("Pasta Bolognese", 40, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        List<String> toppings = Arrays.asList("Truffle Oil");
        List<String> emptyToppings = new ArrayList<>();
        Meal cookedPastaBolognese = factory.makeMeal(pastaBolognese, customer_1.getcustomerDietaryRestriction(), toppings);

        foodItems.add(cookedPastaBolognese);
        // Add more food items as needed

        // Place the order
        Order order = orderServices.placeOrder(restaurant_1, customer_1, driver_1, foodItems);

        // Display Order Detail
        System.out.println("\nOrder placed successfully!");
        System.out.println("*** Order Summary ***");
        System.out.printf("Restaurant: %s\n", order.getRestaurant().getName());
        System.out.printf("Customer: %s\n", order.getCustomer().getCustomerName());
        System.out.printf("Order Creation Time: %s\n", order.getOrderCreationTimeString());
        System.out.printf("Total Price: %.2f\n", order.getTotalPrice()); // Assuming the price is a double
        System.out.println("Items in order:");
        order.displayFoodItems();

        // Display Delivery Detail
        System.out.println("\n*** Delivery Detail ***");
        System.out.printf("Driver: %s\n", order.getDriver().getName());
        System.out.printf("Delivery Address: %s\n", order.getCustomer().getCustomerAddress());
        System.out.printf("Order Pick Up Time: %s\n", order.getOrderPickUpTimeString());
        System.out.printf("Order Deliver Time: %s\n", order.getOrderDeliveredTimeString());

    }
}
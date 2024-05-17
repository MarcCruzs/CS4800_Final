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
        Restaurant restaurant = new ItalianRestaurant("Domenico", "5339 2nd Street", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT);
        restaurant.register();

        // Create a customer
        Customer customer = new Customer("John Doe", "123 Main St", Counties.LA, DietRestrictions.PALEO);
        customer.register();

        // Create a driver
        Driver driver = new Driver("George", "456 That Place", 15, Counties.LA, DriverTimeShifts.FIRST_SHIFT);
        driver.register();

        // Prepare topping lists
        List<String> allToppings = Arrays.asList("Truffle Oil", "Avocado", "Caramelized Onion");
        List<String> truffleOilTopping = Arrays.asList("Truffle Oil");
        List<String> avocadoTopping = Arrays.asList("Avocado");
        List<String> caramelizedOnionTopping = Arrays.asList("Caramelized Onion");

        // Scenario 1: Customer 1 places an order with 1 item at Restaurant 1
        System.out.println("Scenario 1: Placing the order for Customer 1 with 1 item at Restaurant 1...");
        Order order1 = orderServices.buildOrder(restaurant1, customer1, driver1, "08:00 AM");
        order1.addMealByName("Bolognese Pasta", allToppings);
        CPPDelivery.placeOrder(order1, "Domenico");
        System.out.println("Displaying order details for Scenario 1...");
        order1.displayOrder();

        // Scenario 2: Customer 2 places an order at Restaurant 2 with 2 items with a specific topping
        System.out.println("\nScenario 2: Placing the order for Customer 2 at Restaurant 2...");
        Order order2 = orderServices.buildOrder(restaurant2, customer2, driver2, "05:00 AM");
        order2.addMealByName("Beef Tacos", avocadoTopping);
        order2.addMealByName("Breakfast Burritos", truffleOilTopping);
        CPPDelivery.placeOrder(order2, "Enrique's");
        System.out.println("Displaying order details for Scenario 2...");
        order2.displayOrder();

        // Scenario 3: Customer 3 places an order at Restaurant 3 with 3 items
        System.out.println("\nScenario 3: Placing the order for Customer 3 at Restaurant 3...");
        Order order3 = orderServices.buildOrder(restaurant3, customer3, driver3, "05:00 PM");
        order3.addMealByName("Cheeseburger", truffleOilTopping);
        order3.addMealByName("Chicken Salad", caramelizedOnionTopping);
        order3.addMealByName("Meatloaf", Arrays.asList()); // no toppings
        CPPDelivery.placeOrder(order3, "Lacquered");
        System.out.println("Displaying order details for Scenario 3...");
        order3.displayOrder();

        // Scenario 4: Customer places an order at Restaurant 4 when restaurant is not open
        System.out.println("\nScenario 4: Placing the order for Customer 4 at Restaurant 4 when restaurant is not open...");
        Order order4 = orderServices.buildOrder(restaurant4, customer4, driver4, "07:00 PM");
        order4.addMealByName("Risotto", truffleOilTopping);
        CPPDelivery.placeOrder(order4, "La Sopranos");
    }
}
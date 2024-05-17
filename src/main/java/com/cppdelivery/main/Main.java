package com.cppdelivery.main;

import com.cppdelivery.models.*;
import com.cppdelivery.models.food.*;
import com.cppdelivery.services.*;
import com.cppdelivery.utils.*;
import com.cppdelivery.models.restaurants.*;

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

        // Create 4 restaurant
        Restaurant restaurant1 = new ItalianRestaurant("Domenico", "5339 2nd Street", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT, 40);
        Restaurant restaurant2 = new MexicanRestaurant("Enrique's", "129 Pine Avenue", Counties.LA, RestaurantOperatingHours.THIRD_SHIFT, 20);
        Restaurant restaurant3 = new AmericanRestaurant("Lacquered", "1731 4th Street", Counties.SAN_BERNARDINO, RestaurantOperatingHours.SECOND_SHIFT, 30);
        Restaurant restaurant4 = new ItalianRestaurant("La Sopranos", "5339 2nd Street", Counties.SAN_BERNARDINO, RestaurantOperatingHours.FIRST_SHIFT, 25);

        restaurant1.register();
        restaurant2.register();
        restaurant3.register();
        restaurant4.register();

        // Create 10 customer
        Customer customer1 = new Customer("John Doe", "123 Main St", Counties.LA, DietRestrictions.VEGAN);
        Customer customer2 = new Customer("Jane Smith", "456 Elm St", Counties.LA, DietRestrictions.NO_RESTRICTION);
        Customer customer3 = new Customer("Emily Johnson", "789 Oak St", Counties.SAN_BERNARDINO, DietRestrictions.PALEO);
        Customer customer4 = new Customer("Michael Brown", "321 Pine St", Counties.LA, DietRestrictions.VEGAN);
        Customer customer5 = new Customer("Sarah Davis", "654 Cedar St", Counties.SAN_BERNARDINO, DietRestrictions.PALEO);
        Customer customer6 = new Customer("David Wilson", "987 Spruce St", Counties.LA, DietRestrictions.PALEO);
        Customer customer7 = new Customer("Laura Martinez", "234 Birch St", Counties.LA, DietRestrictions.NO_RESTRICTION);
        Customer customer8 = new Customer("James Taylor", "567 Maple St", Counties.SAN_BERNARDINO, DietRestrictions.VEGAN);
        Customer customer9 = new Customer("Patricia Anderson", "890 Walnut St", Counties.SAN_BERNARDINO, DietRestrictions.PALEO);
        Customer customer10 = new Customer("Robert Thomas", "345 Ash St", Counties.LA, DietRestrictions.NO_RESTRICTION);

        customer1.register();
        customer2.register();
        customer3.register();
        customer4.register();
        customer5.register();
        customer6.register();
        customer7.register();
        customer8.register();
        customer9.register();
        customer10.register();

        // Create 8 driver
        Driver driver1 = new Driver("George", "456 That Place", 15, Counties.LA, DriverTimeShifts.FIRST_SHIFT);
        Driver driver2 = new Driver("Alice", "123 This Street", 20, Counties.LA, DriverTimeShifts.SECOND_SHIFT);
        Driver driver3 = new Driver("Bob", "789 That Avenue", 25, Counties.SAN_BERNARDINO, DriverTimeShifts.THIRD_SHIFT);
        Driver driver4 = new Driver("Carol", "321 Here Lane", 30, Counties.SAN_BERNARDINO, DriverTimeShifts.FIRST_SHIFT);
        Driver driver5 = new Driver("David", "654 There Road", 35, Counties.LA, DriverTimeShifts.SECOND_SHIFT);
        Driver driver6 = new Driver("Eve", "987 Over Street", 40, Counties.LA, DriverTimeShifts.THIRD_SHIFT);
        Driver driver7 = new Driver("Frank", "234 Near Way", 45, Counties.LA, DriverTimeShifts.FIRST_SHIFT);
        Driver driver8 = new Driver("Grace", "567 Close Blvd", 50, Counties.SAN_BERNARDINO, DriverTimeShifts.SECOND_SHIFT);

        driver1.register();
        driver2.register();
        driver3.register();
        driver4.register();
        driver5.register();
        driver6.register();
        driver7.register();
        driver8.register();

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
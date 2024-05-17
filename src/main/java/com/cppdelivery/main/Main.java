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

        // Prepare food items list
        List<Meal> foodItems = new ArrayList<>();
        Meal pastaBolognese = new Meal("Pasta Bolognese", 20, new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        List<String> toppings = Arrays.asList("Truffle Oil", "Avocado");
        Meal cookedPastaBolognese = factory.makeMeal(pastaBolognese, customer1.getcustomerDietaryRestriction(), toppings);
        foodItems.add(cookedPastaBolognese);

        // Place the order
        Order order = orderServices.buildOrder(restaurant1, customer1, driver1, foodItems,"08:00 AM");
        CPPDelivery.placeOrder(order, "Domenico");

        // Display Order Detail
        order.displayOrder();
    }
}
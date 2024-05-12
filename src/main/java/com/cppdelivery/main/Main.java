package com.cppdelivery.main;
import com.cppdelivery.utils.*;
import com.cppdelivery.models.restaurants.*;
import com.cppdelivery.models.restaurants.food.*;

public class Main {
    public static void main(String[] args) {
        // Testing factory, restaurant creation, meals
        MacronutrientFactory factory = MacronutrientFactory.getInstance();
        Restaurant domenicoRestaurant = new ItalianRestaurant("Domenico", "5339 2nd Street", Counties.LA, RestaurantOperatingHours.FIRST_SHIFT);
        domenicoRestaurant.showDetails();
        Meal pastaBolognese = new Meal("Pasta Bolognese", new Carb.Pasta(), new Protein.Beef(), new Fat.OliveOil());
        Meal test = factory.makeMeal(pastaBolognese, "Paleo");
        test.display();

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
    }
}
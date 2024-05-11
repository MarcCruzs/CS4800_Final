package main;
import utils.*;
public class Main {
    public static void main(String[] args) {
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
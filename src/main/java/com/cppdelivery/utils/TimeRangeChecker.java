package com.cppdelivery.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// DUMMY CLASS. ITS CREATED FOR THE SAKE OF SHOWING HOW TO PARSE THROUGH THE DRIVER TIME SHIFTS
public class TimeRangeChecker {
    public static boolean isTimeWithinRange(String time, DriverTimeShifts shiftTime) {
        String startTime = shiftTime.getStartTime();
        String endTime = shiftTime.getEndTime();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        LocalTime checkTime = LocalTime.parse(time, formatter);
        LocalTime start = LocalTime.parse(startTime, formatter);
        LocalTime end = LocalTime.parse(endTime, formatter);

        return !checkTime.isBefore(start) && !checkTime.isAfter(end);
    }

    public static void main(String[] args) {
        DriverTimeShifts shiftTime = DriverTimeShifts.FIRST_SHIFT;
        String time = "10:30 AM"; // Example time to check

        // Check if the time is within the range
        boolean inRange = isTimeWithinRange(time, shiftTime);
        System.out.println(inRange);
    }
}

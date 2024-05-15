package com.cppdelivery.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    public static boolean isAvailableAtTime(String time, String startTime2, String endTime2) {
        String startTime = startTime2;
        String endTime = endTime2;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        LocalTime checkTime = LocalTime.parse(time, formatter);
        LocalTime start = LocalTime.parse(startTime, formatter);
        LocalTime end = LocalTime.parse(endTime, formatter);

        return !checkTime.isBefore(start) && !checkTime.isAfter(end);
    }
    public static String addTime(String time, double duration) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        // Convert the String time to LocalTime
        LocalTime localTime = LocalTime.parse(time, formatter);

        // Calculate hours and minutes from duration
        long hours = (long) (duration / 60);
        long minutes = (long) (duration % 60);

        // Add hours and minutes to the time
        LocalTime newTime = localTime.plusHours(hours).plusMinutes(minutes);

        // Return the formatted new time as a String
        return newTime.format(formatter);
    }
}

package com.cppdelivery.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// DUMMY CLASS. ITS CREATED FOR THE SAKE OF SHOWING HOW TO PARSE THROUGH THE DRIVER TIME SHIFTS
public class TimeRangeChecker {
    public static boolean isAvailableAtTime(String time, String startTime2, String endTime2) {
        String startTime = startTime2;
        String endTime = endTime2;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        LocalTime checkTime = LocalTime.parse(time, formatter);
        LocalTime start = LocalTime.parse(startTime, formatter);
        LocalTime end = LocalTime.parse(endTime, formatter);

        return !checkTime.isBefore(start) && !checkTime.isAfter(end);
    }
}

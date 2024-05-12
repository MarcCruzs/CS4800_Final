package com.cppdelivery.utils;

public enum RestaurantOperatingHours {
    FIRST_SHIFT("08:00 AM", "04:00 PM"),
    SECOND_SHIFT("04:00 PM", "12:00 AM"),
    THIRD_SHIFT("12:00 AM", "08:00 AM");

    private final String startTime;
    private final String endTime;

    // Constructor for enum
    RestaurantOperatingHours(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getter for start time
    public String getStartTime() {
        return this.startTime;
    }

    // Getter for end time
    public String getEndTime() {
        return this.endTime;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime;
    }
}

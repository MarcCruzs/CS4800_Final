package com.cppdelivery.utils;

public enum DriverTimeShifts {
    FIRST_SHIFT("08:00 AM", "04:00 PM"),
    SECOND_SHIFT("04:00 PM", "11:30 PM"),
    THIRD_SHIFT("12:00 AM", "08:00 AM");

    private final String startTime;
    private final String endTime;

    DriverTimeShifts(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    // Optional: Override toString() method to return name
    @Override
    public String toString() {
        return name().replace("_", " ");
    }
}

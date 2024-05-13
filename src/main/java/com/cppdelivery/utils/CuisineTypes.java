package com.cppdelivery.utils;

public enum CuisineTypes {
    MEXICAN,
    AMERICAN,
    ITALIAN,
    ASIAN;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}

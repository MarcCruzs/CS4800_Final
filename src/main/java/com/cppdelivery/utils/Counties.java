package com.cppdelivery.utils;

public enum Counties {
    LA,
    ORANGE,
    SAN_BERNARDINO;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}

package com.cppdelivery.utils;

public enum DietRestrictions {
    PALEO,
    VEGAN,
    NUT_ALLERGY;

    @Override
    public String toString() {
        return name().replace('_', ' ')
                .toLowerCase()
                .substring(0, 1).toUpperCase()
                + name().substring(1).toLowerCase().replace('_', ' ');
    }}

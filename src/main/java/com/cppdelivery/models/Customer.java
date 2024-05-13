package com.cppdelivery.models;
import com.cppdelivery.utils.*;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String customerAddress;
    private Counties customerCounty;
    private DietRestrictions customerDietaryRestriction;

    //
    public Customer(String customerName, String customerAddress, Counties customerCounty, DietRestrictions customerDietaryRestriction){
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerCounty = customerCounty;
        this.customerDietaryRestriction = customerDietaryRestriction;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Counties getCustomerCounty() {
        return customerCounty;
    }

    public DietRestrictions getcustomerDietaryRestriction() {
        return customerDietaryRestriction;
    }
}

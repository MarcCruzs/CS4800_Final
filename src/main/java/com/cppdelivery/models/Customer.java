package com.cppdelivery.models;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String customerAddress;
    private String customerCounty;
    private List<String> customerDietaryRestrictions;

    //
    public Customer(String customerName, String customerAddress, String customerCounty){
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerCounty = customerCounty;
        this.customerDietaryRestrictions = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerCounty() {
        return customerCounty;
    }

    public List<String> getCustomerDietaryRestrictions() {
        return customerDietaryRestrictions;
    }

    // Method to add dietary restrictions
    public void addCustomerDietaryRestrictions(String dietaryRestrictions) {
        customerDietaryRestrictions.add(dietaryRestrictions);
    }


}

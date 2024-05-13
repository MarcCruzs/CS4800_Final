package com.cppdelivery.models;
import com.cppdelivery.services.DeliveryServices;
import com.cppdelivery.utils.*;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String customerAddress;
    private Counties customerCounty;
    private DietRestrictions customerDietaryRestriction;
    private DeliveryServices CPPDeliveryServices;



    //
    public Customer(String customerName, String customerAddress, Counties customerCounty, DietRestrictions customerDietaryRestriction){
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerCounty = customerCounty;
        this.customerDietaryRestriction = customerDietaryRestriction;
        this.CPPDeliveryServices = DeliveryServices.getInstance();
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

    public void register(){
        CPPDeliveryServices.registerCustomer(this);
    }
}

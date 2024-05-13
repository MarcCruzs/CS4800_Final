package com.cppdelivery.models;

import com.cppdelivery.services.DeliveryServices;
import com.cppdelivery.utils.Counties;
import com.cppdelivery.utils.DriverTimeShifts;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.cppdelivery.utils.TimeRangeChecker.isAvailableAtTime;

public class Driver {
    private String name;
    private String address;
    private double averageDeliverTime;
    private Counties operatingCounty;
    private DriverTimeShifts operatingHours;
    private DeliveryServices CPPDeliveryServices;

    public Driver(String name, String address, double averageDeliverTime, Counties operatingCounty, DriverTimeShifts operatingHours) {
        this.name = name;
        this.address = address;
        this.averageDeliverTime = averageDeliverTime;
        this.operatingCounty = operatingCounty;
        this.operatingHours = operatingHours;
        this.CPPDeliveryServices = DeliveryServices.getInstance();
    }

    public void register(){
        CPPDeliveryServices.registerDriver(this);
    }

    public boolean isDriverAvailable(String time) {
        return isAvailableAtTime(time, this.operatingHours.getStartTime(), this.operatingHours.getEndTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverageDeliverTime() {
        return averageDeliverTime;
    }

    public void setAverageDeliverTime(double averageDeliverTime) {
        this.averageDeliverTime = averageDeliverTime;
    }

    public Counties getOperatingCounty() {
        return operatingCounty;
    }

    public void setOperatingCounty(Counties operatingCounty) {
        this.operatingCounty = operatingCounty;
    }

    public DeliveryServices getCPPDeliveryServices() {
        return CPPDeliveryServices;
    }

    public void setCPPDeliveryServices(DeliveryServices CPPDeliveryServices) {
        this.CPPDeliveryServices = CPPDeliveryServices;
    }

    public DriverTimeShifts getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(DriverTimeShifts operatingHours) {
        this.operatingHours = operatingHours;
    }
}

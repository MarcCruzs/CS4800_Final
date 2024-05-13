package com.cppdelivery.models;

import com.cppdelivery.services.DeliveryServices;
import com.cppdelivery.utils.Counties;
import com.cppdelivery.utils.DriverTimeShifts;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Driver {
    private String name;
    private String address;
    private Counties operatingCounty;
    private DriverTimeShifts operatingHours;
    private DeliveryServices CPPDeliveryServices;

    public Driver(String name, String address, Counties operatingCounty, DriverTimeShifts operatingHours) {
        this.name = name;
        this.address = address;
        this.operatingCounty = operatingCounty;
        this.operatingHours = operatingHours;
    }

    public void register(){
        System.out.println("Driver registered with name: " + name + " and address: " + address);
        CPPDeliveryServices.registerDriver(this);
    }

    public boolean isDriverAvailable(String time) {
        String startTime = this.operatingHours.getStartTime();
        String endTime = this.operatingHours.getEndTime();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        LocalTime checkTime = LocalTime.parse(time, formatter);
        LocalTime start = LocalTime.parse(startTime, formatter);
        LocalTime end = LocalTime.parse(endTime, formatter);

        return !checkTime.isBefore(start) && !checkTime.isAfter(end);
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

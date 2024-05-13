package com.cppdelivery.services;

import com.cppdelivery.models.Customer;
import com.cppdelivery.models.Driver;
import com.cppdelivery.models.Order;
import com.cppdelivery.models.restaurants.Restaurant;
import com.cppdelivery.utils.Counties;
import com.cppdelivery.utils.DriverTimeShifts;
import com.cppdelivery.utils.RestaurantOperatingHours;

import java.util.ArrayList;

public class DeliveryServices {
    private ArrayList<Driver> registeredDrivers;
    private ArrayList<Customer> registeredCustomers;
    private ArrayList<Restaurant> registeredRestaurants;

    public DeliveryServices() {
        this.registeredDrivers = new ArrayList<>();
        this.registeredCustomers = new ArrayList<>();
        this.registeredRestaurants = new ArrayList<>();
    }

    public void placeOrder(Order order){
        if (!deliveryPossibleForOrder(order)){

        }
    }

    public boolean deliveryPossibleForOrder(Order order){
        Driver deliveryDriver = order.getDriver();
        ArrayList<Driver> nearbyDrivers = findNearbyDrivers(order.getCustomer().getCustomerCounty());

        if (nearbyDrivers == null || nearbyDrivers.isEmpty()) {
            return false;
        }

        for (Driver driver : nearbyDrivers) {
            if (driver.isDriverAvailable(order.getOrderCreationTimeString())) {
                deliveryDriver = driver;
                break;
            }
        }

        // Implementation of checking if restaurant is open


        return deliveryDriver != null;
    }

    public ArrayList<Driver> findNearbyDrivers(Counties county){
        ArrayList<Driver> nearbyDrivers = new ArrayList<>();
        for (Driver driver : registeredDrivers) {
            if (driver.getOperatingCounty().equals(county)){
                nearbyDrivers.add(driver);
            }
        }
        if (nearbyDrivers.isEmpty()){
            return null;
        }
        return nearbyDrivers;
    }
//
//    public boolean isRestaurantOpen(Restaurant restaurant){
//        if (registeredRestaurants.contains(restaurant)){
//            if (restaurant.get)
//        }
//    }

    public void registerDriver(Driver driver){
        registeredDrivers.add(driver);
    }

    public void registerCustomer(Customer customer){
        registeredCustomers.add(customer);
    }

    public void registerRestaurant(Restaurant restaurant){
        registeredRestaurants.add(restaurant);
    }

    public boolean isDriverRegistered(Driver driver){
        return registeredDrivers.contains(driver);
    }

    public boolean isCustomerRegistered(Customer customer){
        return registeredCustomers.contains(customer);
    }

    public boolean isRestaurantRegistered(Restaurant restaurant){
        return registeredRestaurants.contains(restaurant);
    }

}

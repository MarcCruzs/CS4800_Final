package com.cppdelivery.services;

import com.cppdelivery.models.Customer;
import com.cppdelivery.models.Driver;
import com.cppdelivery.models.Order;
import com.cppdelivery.models.restaurants.Restaurant;
import com.cppdelivery.utils.Counties;
import com.cppdelivery.utils.DriverTimeShifts;
import com.cppdelivery.utils.RestaurantOperatingHours;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DeliveryServices {
    private static DeliveryServices deliveryServices = null;
    private ArrayList<Driver> registeredDrivers;
    private ArrayList<Customer> registeredCustomers;
    private ArrayList<Restaurant> registeredRestaurants;

    public DeliveryServices() {
        this.registeredDrivers = new ArrayList<>();
        this.registeredCustomers = new ArrayList<>();
        this.registeredRestaurants = new ArrayList<>();
    }

    public static DeliveryServices getInstance(){
        if (deliveryServices == null){
            deliveryServices = new DeliveryServices();
        }
        return deliveryServices;
    }

    public void registerDriver(Driver driver){
        registeredDrivers.add(driver);
    }

    public void registerCustomer(Customer customer){
        registeredCustomers.add(customer);
    }

    public void registerRestaurant(Restaurant restaurant){
        registeredRestaurants.add(restaurant);
    }

    public boolean placeOrder(Order order, String restaurantName){
        if (!isCustomerRegistered(order.getCustomer())){
            System.out.println("Customer is not registered");
            return false;
        }

        if (findRegisteredRestaurant(restaurantName) != null){
            order.setRestaurant(findRegisteredRestaurant(restaurantName));
        }
        else {
            return false;
        }

        order = fulfillOrder(order);

        if (order == null){
            return false;
        }

        System.out.println("Order is accepted! Now delivering");
        deliverOrder(order);
        return true;
    }

    public Order fulfillOrder(Order order){
        ArrayList<Driver> nearbyDrivers = findNearbyRegisteredDrivers(order.getCustomer().getCustomerCounty());

        if (nearbyDrivers == null || nearbyDrivers.isEmpty()) {
            return null;
        }

        for (Driver driver : nearbyDrivers) {
            if (driver.isDriverAvailable(order.getOrderCreationTimeString())) {
                order.setDriver(driver);
                break;
            }
        }

        if (order.getDriver() == null){
            System.out.println("No available driver was found");
            return null;
        }

        if (!order.getRestaurant().isRestaurantAvailable(order.getOrderCreationTimeString())){
            System.out.println("Restaurant is not open");
            return null;
        }

        return order;
    }

    private void deliverOrder(Order order){
        Driver driver = order.getDriver();

        LocalDateTime orderCreationTime = order.getOrderCreationTime();
        double averageDeliveryTime = driver.getAverageDeliverTime();

        LocalDateTime orderDeliveredTime = addTime(orderCreationTime, averageDeliveryTime);
        LocalDateTime orderPickUpTime = addTime(orderDeliveredTime, averageDeliveryTime);

        order.setOrderDeliveredTime(orderDeliveredTime);
        order.setOrderPickUpTime(orderPickUpTime);

        System.out.println("Order Delivered");
    }

    public LocalDateTime addTime(LocalDateTime time, double deliveryTime) {
        long hours = (long) deliveryTime;
        long minutes = (long) ((deliveryTime - hours) * 60);
        return time.plusHours(hours).plusMinutes(minutes);
    }

    private ArrayList<Driver> findNearbyRegisteredDrivers(Counties county){
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

    public Restaurant findRegisteredRestaurant(String name){
        for (Restaurant restaurant : registeredRestaurants){
            if (restaurant.getName().equals(name)){
                return restaurant;
            }
        }
        System.out.println("Restaurant is not registered with CPPDelivery");
        return null;
    }

    public boolean isCustomerRegistered(Customer customer){
        return registeredCustomers.contains(customer);
    }

}

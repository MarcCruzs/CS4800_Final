package com.cppdelivery.models;
// Min
// Use Builder Class-- create OrderBuilder
import com.cppdelivery.models.food.MacronutrientFactory;
import com.cppdelivery.models.restaurants.Restaurant;
import com.cppdelivery.models.food.Meal;
import com.cppdelivery.services.DeliveryServices;
import com.cppdelivery.utils.DietRestrictions;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;
    private final List<Meal> foodItemList;
    private String orderCreationTime;
    private String orderPickUpTime;
    private String orderDeliveredTime;
    private MacronutrientFactory macronutrientFactory;
    public Order(Restaurant restaurant, Customer customer, Driver driver, String orderCreationTime){
        this.restaurant = restaurant;
        this.customer = customer;
        this.driver = driver;
        this.foodItemList = new ArrayList<>();
        this.orderCreationTime = orderCreationTime;
        this.macronutrientFactory = MacronutrientFactory.getInstance();
    }
    public void addMealByName(String mealName, List<String> toppings) {
        Meal meal = restaurant.getMealByName(mealName);
        if (meal != null) {
            DietRestrictions dietPlan = customer.getcustomerDietaryRestriction();
            Meal cookedMeal = macronutrientFactory.makeMeal(meal, dietPlan, toppings);
            foodItemList.add(cookedMeal);
        } else {
            System.out.println("Meal not found: " + mealName);
        }
    }
    public Restaurant getRestaurant(){
        return restaurant;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Driver getDriver(){
        return driver;
    }
    public List<Meal> getFoodItemList(){
        return foodItemList;
    }
    public void displayFoodItems() {
        foodItemList.forEach(Meal::display);
    }
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Meal meal : foodItemList) {
            totalPrice += meal.getPrice();
        }
        return totalPrice;
    }
    public String getOrderCreationTimeString(){
        return orderCreationTime;
    }
    public String getOrderPickUpTimeString(){
        if(orderPickUpTime != null)
            return orderPickUpTime;
        else
            return "Not picked up yet";
    }
    public String getOrderDeliveredTimeString(){
        if(orderDeliveredTime != null)
            return orderDeliveredTime;
        else
            return "Not delivered up yet";
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(String orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public String getOrderPickUpTime() {
        return orderPickUpTime;
    }
    public void setOrderPickUpTime(String orderPickUpTime) {
        this.orderPickUpTime = orderPickUpTime;
    }


    public String getOrderDeliveredTime() {
        return orderDeliveredTime;
    }
    public void setOrderDeliveredTime(String orderDeliveredTime){
        this.orderDeliveredTime = orderDeliveredTime;
    }
    public void displayOrder() {
        System.out.println("Order Information:");
        System.out.println("**** Order Details ****");
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Food Items:");
        displayFoodItems();
        System.out.println("Total Price: " + getTotalPrice());

        System.out.println("**** Delivery Details ****");
        System.out.println("Driver: " + driver.getName());
        System.out.println("Order Creation Time: " + getOrderCreationTimeString());
        System.out.println("Order Pick-Up Time: " + getOrderPickUpTimeString());
        System.out.println("Order Delivered Time: " + getOrderDeliveredTimeString());
    }
}

package com.cppdelivery.testcases;

import com.cppdelivery.models.Driver;
import com.cppdelivery.services.DeliveryServices;
import com.cppdelivery.utils.Counties;
import com.cppdelivery.utils.DriverTimeShifts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    private Driver driver;
    private DeliveryServices deliveryServices;
    private DriverTimeShifts timeShifts;

    @BeforeEach
    void setUp() {
        deliveryServices = DeliveryServices.getInstance();
        timeShifts = DriverTimeShifts.FIRST_SHIFT;
        driver = new Driver("John Doe", "123 Elm Street", 30.0, Counties.LA, timeShifts);
        driver.setCPPDeliveryServices(deliveryServices);
    }

    @Test
    void register() {
        deliveryServices.registerDriver(driver);
        assertTrue(deliveryServices.isDriverRegistered(driver));
    }

    @Test
    void isDriverAvailable() {
        assertTrue(driver.isDriverAvailable("10:00 AM"));
        assertFalse(driver.isDriverAvailable("07:00 AM"));
    }

    @Test
    void getName() {
        assertEquals("John Doe", driver.getName());
    }

    @Test
    void setName() {
        driver.setName("Jane Doe");
        assertEquals("Jane Doe", driver.getName());
    }

    @Test
    void getAddress() {
        assertEquals("123 Elm Street", driver.getAddress());
    }

    @Test
    void setAddress() {
        driver.setAddress("456 Oak Street");
        assertEquals("456 Oak Street", driver.getAddress());
    }

    @Test
    void getAverageDeliverTime() {
        assertEquals(30.0, driver.getAverageDeliverTime());
    }

    @Test
    void setAverageDeliverTime() {
        driver.setAverageDeliverTime(25.0);
        assertEquals(25.0, driver.getAverageDeliverTime());
    }

    @Test
    void getOperatingCounty() {
        assertEquals(Counties.LA, driver.getOperatingCounty());
    }

    @Test
    void setOperatingCounty() {
        driver.setOperatingCounty(Counties.ORANGE);
        assertEquals(Counties.ORANGE, driver.getOperatingCounty());
    }

    @Test
    void getCPPDeliveryServices() {
        assertEquals(deliveryServices, driver.getCPPDeliveryServices());
    }

    @Test
    void setCPPDeliveryServices() {
        DeliveryServices newDeliveryServices = DeliveryServices.getInstance();
        driver.setCPPDeliveryServices(newDeliveryServices);
        assertEquals(newDeliveryServices, driver.getCPPDeliveryServices());
    }

    @Test
    void getOperatingHours() {
        assertEquals(timeShifts, driver.getOperatingHours());
    }

    @Test
    void setOperatingHours() {
        DriverTimeShifts newTimeShifts = DriverTimeShifts.THIRD_SHIFT;
        driver.setOperatingHours(newTimeShifts);
        assertEquals(newTimeShifts, driver.getOperatingHours());
    }
}

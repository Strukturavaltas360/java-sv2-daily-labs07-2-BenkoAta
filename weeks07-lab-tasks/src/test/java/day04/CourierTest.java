package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    Courier courier = new Courier();
    Ride ride1 = new Ride(1, 1, 11.4);
    Ride ride2 = new Ride(1, 2, 12.4);
    Ride ride3 = new Ride(1, 3, 13.4);
    Ride ride4 = new Ride(2, 4, 14.4);
    Ride ride5 = new Ride(2, 5, 15.4);
    Ride ride6 = new Ride(2, 6, 16.4);

    @Test
    void addRideTest() {
        courier.addRide(ride1);
        courier.addRide(ride2);
        courier.addRide(ride3);
        courier.addRide(ride4);
        courier.addRide(ride5);
        courier.addRide(ride6);
        assertEquals(6, courier.getRides().size());
    }

    @Test
    void addRideTestException1() {
        courier.addRide(ride2);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> courier.addRide(ride1));
        assertEquals("Ride numbers must be in ascending order!", iae.getMessage());
        iae = assertThrows(IllegalArgumentException.class, () -> courier.addRide(ride2));
        assertEquals("Ride numbers must be in ascending order!", iae.getMessage());
    }

    @Test
    void addRideTestException2() {
        courier.addRide(ride5);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> courier.addRide(ride1));
        assertEquals("Ride days must be in ascending order!", iae.getMessage());
    }
}
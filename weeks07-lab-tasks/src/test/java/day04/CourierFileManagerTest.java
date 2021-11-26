package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CourierFileManagerTest {

    @Test
    void createCourierByFile() {
        Path path = Paths.get("src/main/resources/courier.txt");
        CourierFileManager courierFileManager = new CourierFileManager();
        Courier courier = courierFileManager.createCourierByFile(path);

        assertEquals(6, courier.getRides().size());
        Ride ride = courier.getRides().get(5);
        assertEquals(4, ride.getDayOfWeek());
        assertEquals(3, ride.getRideNumber());
        assertEquals(9, ride.getDistance());
    }
}
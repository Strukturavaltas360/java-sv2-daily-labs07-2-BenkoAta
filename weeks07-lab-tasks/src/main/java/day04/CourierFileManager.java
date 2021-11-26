package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class CourierFileManager {
    public Courier createCourierByFile(Path path) {
        Courier courier = new Courier();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line: lines) {
                courier.addRide(constructRide(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file!");
        }
        return courier;
    }

    private Ride constructRide(String line) {
        Scanner scanner = new Scanner(line);
        int day = scanner.nextInt();
        int rideNo = scanner.nextInt();
        double distance = scanner.nextDouble();
        return new Ride(day, rideNo, distance);
    }
}

package day04;

public class Ride {
    private int dayOfWeek;
    private int rideNumber;
    private double distance;

    public Ride(int dayOfWeek, int rideNumber, double distance) {
        this.dayOfWeek = dayOfWeek;
        this.rideNumber = rideNumber;
        this.distance = distance;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public double getDistance() {
        return distance;
    }
}

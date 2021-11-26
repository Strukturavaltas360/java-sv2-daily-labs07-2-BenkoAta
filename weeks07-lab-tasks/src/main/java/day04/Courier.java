package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        checkRideOrder(ride);
        rides.add(ride);
    }

    private void checkRideOrder(Ride ride) {
        if (rides.size() > 0) {
            Ride lastRide = rides.get(rides.size() - 1);
            if (ride.getDayOfWeek() < lastRide.getDayOfWeek()) {
                throw new IllegalArgumentException("Ride days must be in ascending order!");
            }
            if (ride.getDayOfWeek() == lastRide.getDayOfWeek() && ride.getRideNumber() <= lastRide.getRideNumber()) {
                throw new IllegalArgumentException("Ride numbers must be in ascending order!");
            }
        }
    }

    public List<Ride> getRides() {
        return rides;
    }
}

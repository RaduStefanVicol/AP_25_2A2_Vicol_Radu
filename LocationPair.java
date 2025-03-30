package org.example;
import java.util.Random;
public class LocationPair {
    private final Location firstLocation;
    private final Location secondLocation;

    public int getDirectTime() {
        return directTime;
    }

    private final int directTime;
    private int pathTime;

    public int getSafetyPenalty() {
        return 100-this.safetyPercentage;
    }

    private final int safetyPercentage;
    public LocationPair(Location firstLocation, Location secondLocation) {
        this.firstLocation = firstLocation;
        this.secondLocation = secondLocation;
        Random random = new Random();
        this.directTime= random.nextInt(100);
        this.safetyPercentage=100-firstLocation.getSafetyPenalty()-secondLocation.getSafetyPenalty();
    }


}

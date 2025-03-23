package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = Arrays.asList(
                new Location("TwoFort"),
                new Location("5Gorge"),
                new Location("DustBowl"),
                new Location("HighTower"),
                new Location("BadwaterBasin")
        );
        locations.get(0).setType(Location.LocationType.FRIENDLY);
        locations.get(1).setType(Location.LocationType.ENEMY);
        locations.get(2).setType(Location.LocationType.NEUTRAL);
        locations.get(3).setType(Location.LocationType.FRIENDLY);
        locations.get(4).setType(Location.LocationType.ENEMY);

        TreeSet<Location> friendlyLocations = locations.stream()
                .filter(loc -> loc.getType() == Location.LocationType.FRIENDLY)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Sorted Friendly Locations: ");
        friendlyLocations.forEach(System.out::println);
        System.out.println("\n");

        LinkedList<Location> enemyLocations = locations.stream()
                .filter(loc -> loc.getType() == Location.LocationType.ENEMY)
                .sorted(Comparator.comparing(Location::getType)
                        .thenComparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("Sorted Enemy Locations: ");
        enemyLocations.forEach(System.out::println);
    }
}

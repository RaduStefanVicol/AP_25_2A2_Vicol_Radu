package org.example;

import java.util.*;
import java.util.stream.Collectors;
import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("TwoFort"),
                new Location("5Gorge"),
                new Location("DustBowl"),
                new Location("HighTower"),
                new Location("BadwaterBasin")
        ));
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

        Faker faker = new Faker();
/*
        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String streetAddress = faker.address().streetAddress();
        System.out.println(streetAddress);

*/
        String randomName1 = String.valueOf(faker.name());
        Location random1 = new Location(randomName1);
        locations.add(random1);

        Location random2 = new Location();
        locations.add(random2);
        System.out.println(random2);


        System.out.println(locations);

        GraphSolution myGraph = new GraphSolution(locations);
        myGraph.GenerateGraph(1);
    }

}

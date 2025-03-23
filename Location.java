package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Location implements Comparable<Location> {

    private String name;
    private LocationType type;
    public enum LocationType {
        FRIENDLY, NEUTRAL, ENEMY
    }

    public Location(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
    }


}

package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.github.javafaker.Faker;

import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Location implements Comparable<Location> {

    private String name;
    private int randomInt; //type cand sunt lenes si nu merge enum in solution
    private LocationType type;
    private int SafetyPenalty;
    private int SortNumber;
    public enum LocationType {
        FRIENDLY, NEUTRAL, ENEMY
    }

    public Location(String name) {
        this.name = name;
    }

    public void SetLocationType(String s){
        if (s.equals("FRIENDLY")) {
            this.type = LocationType.valueOf(s.toUpperCase()); // Converts String to Enum
            this.SafetyPenalty=0;
            this.randomInt=0;

        }
            else if (s.equals("NEUTRAL")) {
            this.type = LocationType.valueOf(s.toUpperCase());
            this.SafetyPenalty=20;
            this.randomInt=1;

        }
            else if (s.equals("ENEMY")){
                this.type = LocationType.valueOf(s.toUpperCase());
                this.SafetyPenalty=40;
                this.randomInt=2;
        }
            else throw new IllegalArgumentException("Invalid location type: " + s);
        }
    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
    }
    //location constructor cu totul random
    public Location(){
        Faker faker = new Faker();
        this.name = faker.name().lastName();
        Random random = new Random();
        this.randomInt = random.nextInt(3);
        if (randomInt==0) {
            this.SetLocationType("FRIENDLY");
        }
        else if (randomInt==1) {
            this.SetLocationType("NEUTRAL");
        }
        else this.SetLocationType("ENEMY");
    }

}

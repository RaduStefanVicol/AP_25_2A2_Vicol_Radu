package org.example.lab7experiment;

public class Letter {
    private final char value;
    private int points=0;
    public Letter(char value) {
        this.value = value;
        this.points=setPointValue(value);
    }
    private int setPointValue(char c){
        String s ="ETAON RISHD LFCMU GYPWB VKJXZQ";
        return s.indexOf(c)/6+1;
    }
    public char getValue() {
        return value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

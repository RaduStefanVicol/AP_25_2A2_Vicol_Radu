package org.example.lab7experiment;

public class Letter {
    private final char value;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

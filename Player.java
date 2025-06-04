package org.example.lab7experiment;

import java.util.ArrayList;

public class Player {
    public String getName() {
        return name;
    }
    private int points;
    private final String name;
    private ArrayList<Letter> playLetters = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        this.points=0;
    }

    public ArrayList<Letter> getPlayLetters() {
        return playLetters;
    }

    public void addLetter(char c) {
        Letter l = new Letter(c);
        this.playLetters.add(l);
    }

    public void discardLetters(String word, int validPoints) {
        for (char c : word.toUpperCase().toCharArray()) {
            for (int i = 0; i < playLetters.size(); i++) {
                if (playLetters.get(i).getValue() == c) {
                    //Letter newC = new Letter(c);
                    playLetters.remove(i);
                    break; // remove only one
                }
            }
        }
        this.points += validPoints;
    }
    public void displayLetters() {
        System.out.println(getName() + getPlayLetters().toString());
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getLettersAsString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : playLetters) {
            sb.append(letter.getValue());
        }
        return sb.toString();
    }

}

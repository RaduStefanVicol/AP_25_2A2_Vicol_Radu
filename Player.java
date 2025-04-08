package org.example.lab7experiment;

import java.util.ArrayList;

public class Player {
    public String getName() {
        return name;
    }

    private final String name;
    private ArrayList<Letter> playLetters= new ArrayList<>();

    public Player(String name) {
        this.name=name;
    }

    public ArrayList<Letter> getPlayLetters() {
        return playLetters;
    }

    public void addLetter(char c) {
        Letter l = new Letter(c);
        this.playLetters.add(l);
    }
    public void discardLetters(char c){
        this.playLetters.clear();
    }

    public void displayLetters(){
        System.out.println(getName() + getPlayLetters().toString());
    }
}

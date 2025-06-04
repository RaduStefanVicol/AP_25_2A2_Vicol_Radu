package org.example.lab7experiment;

import java.util.ArrayList;

public class Daemon extends Thread {
    private final ArrayList<Thread> players;

    public Daemon(ArrayList<Thread> players) {
        this.players = players;
        setDaemon(true);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Daemon was interrupted.");
            return;
        }

        System.out.println("Time's up! Game over");
        for (Thread t : players) {
            t.interrupt(); // Interrupt all player threads
        }
    }
}

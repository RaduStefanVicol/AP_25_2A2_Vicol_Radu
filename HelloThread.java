package org.example.lab7experiment;

import java.util.Random;
import static org.example.lab7experiment.HelloApplication.removeLetterFromBag;

public class HelloThread extends Thread {
    @Override
    public void run() {
        int newValue = HelloApplication.globalCounter.incrementAndGet();
        Player player = new Player("Jucatorul" + newValue);
        HelloApplication.playerList.add(player);

        Random random = new Random();

        while (true) {
            if (HelloApplication.getLetterBag().isEmpty()) break;

            int randomLetterNr = random.nextInt(26);
            char randomLetter = (char) ('A' + randomLetterNr); // changed to uppercase

            boolean taken = removeLetterFromBag(randomLetter);
            if (taken) {
                player.addLetter(randomLetter);
                System.out.println("Player: " + player.getName() + " took out " + randomLetter);
            }
        }
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        player.displayLetters();
    }
}

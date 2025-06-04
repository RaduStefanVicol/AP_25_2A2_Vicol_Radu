package org.example.lab7experiment;

import java.util.Random;
import static org.example.lab7experiment.HelloApplication.removeLetterFromBag;

public class HelloThread extends Thread {
    private int playerId;

    @Override
    public void run() {
        playerId = HelloApplication.globalCounter.incrementAndGet();
        Player player = new Player("Jucatorul" + playerId);
        HelloApplication.playerList.add(player);

        Random random = new Random();

        while (true) {
            synchronized (HelloApplication.turnLock) {
                // Wait until it's this player's turn
                while (HelloApplication.currentTurn.get() != playerId) {
                    try {
                        HelloApplication.turnLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                if (HelloApplication.getLetterBag().isEmpty()) {
                    HelloApplication.turnLock.notifyAll(); // wake others to finish
                    break;
                }

                int lettersTaken = player.getPlayLetters().size();
                while (lettersTaken < 7 && !HelloApplication.getLetterBag().isEmpty()) {
                    char randomLetter = (char) ('A' + random.nextInt(26));
                    boolean taken = removeLetterFromBag(randomLetter);
                    if (taken) {
                        player.addLetter(randomLetter);
                        lettersTaken++;
                        synchronized (HelloApplication.printLock) {
                            System.out.println("Player: " + player.getName() + " took out " + randomLetter);
                            player.displayLetters();
                        }
                    }
                }
                Dictionary dic = new Dictionary(
                        "C:/Users/Acer/Desktop/CodeJava PA/Lab7experiment/src/main/java/org/example/lab7experiment/words.txt"
                );
                String theWord=player.getLettersAsString();
                int validPoints=dic.isInDictionary(theWord);
                player.discardLetters(theWord, validPoints);

                if (player.getPlayLetters().size()>=7)
                    player.discardLetters(theWord, 0);

                int totalPlayers = HelloApplication.globalCounter.get();
                int nextTurn = playerId + 1;
                if (nextTurn > totalPlayers) {
                    nextTurn = 1;
                }
                HelloApplication.currentTurn.set(nextTurn);

                HelloApplication.turnLock.notifyAll();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        /* Display player's final letters after all turns
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        player.displayLetters();*/
    }
}

package org.example.lab7experiment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HelloApplication extends Application {
    private int numberOfPlayers = -1;
    private Pane centerPane;
    public static final Object printLock = new Object();

    public static BlockingQueue<Letter> getLetterBag() {
        return letterBag;
    }

    private static BlockingQueue<Letter> letterBag = new LinkedBlockingQueue<>();
    public static ArrayList<Player> playerList= new ArrayList<>();
    public static final AtomicInteger globalCounter = new AtomicInteger(0);
    @Override
    public void start(Stage stage) {
        // Top panel: Number of players, New Game
        Button btnNrPlayers = new Button("Number of players:");
        TextField dotInput = new TextField("10");
        Button btnNewGame = new Button("New Game");

        btnNewGame.setOnAction(e -> {
            try {
                numberOfPlayers = Integer.parseInt(dotInput.getText());
                System.out.println("New game with " + numberOfPlayers + " players.");
                startPlayers(numberOfPlayers);
            } catch (NumberFormatException ex) {
                System.err.println("Please enter a valid integer for number of players.");
            }
        });

        HBox topPanel = new HBox(10, btnNrPlayers, dotInput, btnNewGame);
        topPanel.setStyle("-fx-padding: 10; -fx-alignment: center;");

        // Bottom panel: Exit
        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> System.exit(0));
        HBox bottomPanel = new HBox(10, btnExit);
        bottomPanel.setStyle("-fx-padding: 10; -fx-alignment: center;");

        // Center pane for drawing dots
        centerPane = new Pane();
        centerPane.setStyle("-fx-background-color: teal;");
        //centerPane.setPrefSize(800, 10);

        // Main layout
        BorderPane root = new BorderPane();
        root.setTop(topPanel);
        root.setBottom(bottomPanel);
        root.setCenter(centerPane);

        Scene scene = new Scene(root, 500, 100);
        stage.setTitle("Word Game");
        stage.setScene(scene);
        stage.show();
    }

    private void startPlayers(int numberOfPlayers) {
        centerPane.getChildren().clear();
        //reset bag
        resetBag(letterBag);
        //add players
        //start threads for each
        for (int i=0;i<this.numberOfPlayers;i++) {
            Thread player = new HelloThread();
            player.start();
        }
    }
    public void resetBag(BlockingQueue<Letter> letterBag){
        this.letterBag.clear();
        for (char c = 'A'; c <= 'Z'; c++) {
            for (int i = 0; i < 10; i++) {
                letterBag.add(new Letter(c));
            }
        }
    }
    public static boolean removeLetterFromBag(char targetChar) {
        synchronized (letterBag) {
            for (Letter letter : letterBag) {
                if (letter.getValue() == targetChar) {
                    letterBag.remove(letter);
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

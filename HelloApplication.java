package org.example.lab6fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class HelloApplication extends Application {
    private int numberOfDots = -1;
    private Pane centerPane;

    @Override
    public void start(Stage stage) {
        // Top panel: Number of dots, New Game
        Button btnNrDots = new Button("Number of dots:");
        TextField dotInput = new TextField("10");
        Button btnNewGame = new Button("New Game");

        btnNewGame.setOnAction(e -> {
            try {
                numberOfDots = Integer.parseInt(dotInput.getText());
                System.out.println("New game with " + numberOfDots + " dots.");
                drawDots(numberOfDots);
            } catch (NumberFormatException ex) {
                System.err.println("Please enter a valid integer for number of dots.");
            }
        });

        HBox topPanel = new HBox(10, btnNrDots, dotInput, btnNewGame);
        topPanel.setStyle("-fx-padding: 10; -fx-alignment: center;");

        // Bottom panel: Load, Save, Exit
        Button btnLoad = new Button("Load");
        Button btnSave = new Button("Save");
        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> System.exit(0));
        HBox bottomPanel = new HBox(10, btnLoad, btnSave, btnExit);
        bottomPanel.setStyle("-fx-padding: 10; -fx-alignment: center;");

        // Center pane for drawing dots
        centerPane = new Pane();
        centerPane.setStyle("-fx-background-color: white;");
        centerPane.setPrefSize(800, 500);

        // Main layout
        BorderPane root = new BorderPane();
        root.setTop(topPanel);
        root.setBottom(bottomPanel);
        root.setCenter(centerPane);

        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("Dot Game");
        stage.setScene(scene);
        stage.show();
    }

    private void drawDots(int numberOfDots) {
        centerPane.getChildren().clear();
        Random random = new Random();

        for (int i = 0; i < numberOfDots; i++) {
            Circle dot = new Circle();
            dot.setRadius(5);
            dot.setFill(Color.RED);
            dot.setCenterX(50 + random.nextDouble() * (centerPane.getPrefWidth() - 100));
            dot.setCenterY(50 + random.nextDouble() * (centerPane.getPrefHeight() - 100));

            centerPane.getChildren().add(dot);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package org.example.lab6fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private static Label welcomeText;

    @FXML
    public static void onHelloButtonClick() {
        welcomeText.setText("Enter the number of dots");
    }
}
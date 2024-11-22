package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserPageController {

    @FXML
    private Label welcomeLabel;

    private String username;

    /**
     * Method untuk menginisialisasi data pengguna setelah login.
     * 
     * @param username Username dari pengguna
     */
    public void setUserData(String username) {
        this.username = username;
        welcomeLabel.setText("Welcome, " + username + "!");
    }
}

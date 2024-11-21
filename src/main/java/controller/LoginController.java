package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kelompok4.fishmarket.dao.baseDAO;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    // This method will handle the Login button click event
    @FXML
    public void actionMasuk(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Validation Error", "Username and Password cannot be empty.");
            return;
        }

        // Call the loginUser method to validate credentials
        boolean isLoggedIn = loginUser(username, password);

        if (isLoggedIn) {
            showAlert("Login Success", "Welcome, " + username + "!");
            System.out.println("User logged in successfully.");
        } else {
            showAlert("Login Failed", "Invalid username or password. Please try again.");
        }
    }

    // This method will handle the Sign Up button click event
    @FXML
    public void actionSignUp(ActionEvent event) {
        // Add logic to handle sign-up action, such as opening a new registration window
        System.out.println("Sign Up button clicked");
        // You can implement opening the registration screen here
    }

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Any initialization logic can be placed here
    }

    /**
     * Method to validate user credentials from the database
     * @param username The username entered by the user
     * @param password The password entered by the user
     * @return true if the credentials are valid, false otherwise
     */
    public boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection connection = baseDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if a match is found

        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
            return false;
        }
    }

    /**
     * Utility method to show alerts to the user
     * @param title The title of the alert
     * @param message The content message of the alert
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

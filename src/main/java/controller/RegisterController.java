package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import kelompok4.fishmarket.dao.baseDAO;

public class RegisterController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    public void actionSignUp(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String confirmPassword = confirmPasswordField.getText().trim();

        // Validasi input kosong
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert("Input Error", "All fields must be filled in. Please try again.");
            return;
        }

        // Validasi kesesuaian password
        if (!password.equals(confirmPassword)) {
            showAlert("Password Mismatch", "The passwords you entered do not match. Please try again.");
            return;
        }

        // Simpan data pengguna ke database
        if (registerUser(username, password)) {
            showAlert("Success", "Registration successful. You can now log in.");
            clearFields(); // Membersihkan field setelah registrasi berhasil
        } else {
            showAlert("Error", "Failed to register. Please try again later.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Any initialization logic can go here
    }

    // Method untuk menyimpan pengguna ke database
    private boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection connection = baseDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; // Mengembalikan true jika ada baris yang ditambahkan

        } catch (SQLException e) {
            System.out.println("Error during registration: " + e.getMessage());
            return false;
        }
    }

    // Utility method untuk menampilkan alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION); // Default menjadi INFO
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method untuk membersihkan field input
    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
        confirmPasswordField.clear();
    }
}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Aplikasi utama
 */

public class Newfishmarket extends Application {

    private static final Logger LOGGER = Logger.getLogger(Newfishmarket.class.getName());

    /**
     * Method untuk menjalankan aplikasi JavaFX.
     * 
     * @param stage Stage utama untuk aplikasi.
     */
    @Override
    public void start(Stage stage) {
        try {
            // Memuat FXML dari folder resources
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginRegisterView.fxml"));
            // Set scene menggunakan FXML yang telah dimuat
            stage.setScene(new Scene(loader.load()));
            // Menambahkan title pada window
            stage.setTitle("Demo fx:id");
            // Menampilkan stage
            stage.show();
        } catch (IOException e) {
            // Menampilkan alert kepada pengguna jika file FXML tidak ditemukan
            showErrorAlert("File FXML Tidak Ditemukan", "Terjadi kesalahan saat memuat file FXML. Pastikan file loginRegisterView.fxml ada di folder yang benar.");
            LOGGER.log(Level.SEVERE, "Error saat memuat aplikasi", e);
        }
    }

    /**
     * Menampilkan dialog error kepada pengguna.
     * 
     * @param title   Judul dialog error.
     * @param message Pesan error yang ditampilkan.
     */
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);  // Tidak ada header di alert
        alert.setContentText(message);
        alert.showAndWait();  // Menunggu user menutup alert
    }

    /**
     * Method utama untuk menjalankan aplikasi.
     * 
     * @param args Parameter untuk aplikasi (tidak digunakan di sini).
     */
    public static void main(String[] args) {
        launch(args);
    }
}

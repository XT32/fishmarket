package controller;

import dao.AdminDAO;
import model.Ikan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;

public class adminViewController implements Initializable {

    @FXML
    private AnchorPane Dashboard_form, inventory_form;

    @FXML
    private TableView<Ikan> inventory_table;

    @FXML
    private TableColumn<Ikan, Number> inventory_IDikan, inventory_stok, inventory_harga;

    @FXML
    private TableColumn<Ikan, String> inventory_namaIkan, inventory_gambarIkan;

    @FXML
    private TableColumn<Ikan, Number> inventory_hargaIkan;

    @FXML
    private TextField inventory_namaField, inventory_hargaField, inventory_gambarField, inventory_stokField, inventory_idNelayanField;

    @FXML
    private Button inventory_annButton, inventory_updateButton, inventory_deleteButton, inventory_clearButton;

    private Connection connection;
    private AdminDAO adminDAO;
    private ObservableList<Ikan> ikanList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectToDatabase();
        adminDAO = new AdminDAO(connection);

        // Set kolom tabel inventory
        inventory_IDikan.setCellValueFactory(new PropertyValueFactory<>("idIkan"));
        inventory_namaIkan.setCellValueFactory(new PropertyValueFactory<>("namaIkan"));
        inventory_stok.setCellValueFactory(new PropertyValueFactory<>("stokIkan"));
        inventory_harga.setCellValueFactory(new PropertyValueFactory<>("hargaIkan"));
 
        loadInventoryData();

        // Tombol CRUD
        inventory_annButton.setOnAction(e -> addIkan());
        inventory_updateButton.setOnAction(e -> updateIkan());
        inventory_deleteButton.setOnAction(e -> deleteIkan());
        inventory_clearButton.setOnAction(e -> clearInventoryFields());
    }

    private void connectToDatabase() {
    try {
        connection = DriverManager.getConnection("jdbc:mysql://34.44.81.201:3306/fishmarket", "username", "password");
        if (connection != null) {
            System.out.println("Connection to database established successfully.");
        } else {
            throw new SQLException("Failed to establish connection to database.");
        }
    } catch (SQLException e) {
        showAlert(Alert.AlertType.ERROR, "Database Connection Failed", "Error: " + e.getMessage());
        e.printStackTrace();
    }
}

    private void loadInventoryData() {
        List<Ikan> list = adminDAO.getAllIkan(); // Ambil data dari database
        if (list != null) {
            ikanList = FXCollections.observableArrayList(list); // Konversi ke ObservableList
            inventory_table.setItems(ikanList); // Set data ke TableView
        } else {
            showAlert(Alert.AlertType.WARNING, "Data Load Failed", "No inventory data found.");
        }
}


    private void addIkan() {
        try {
            String nama = inventory_namaField.getText();
            double harga = Double.parseDouble(inventory_hargaField.getText());
            String gambar = inventory_gambarField.getText();
            int stok = Integer.parseInt(inventory_stokField.getText());
            int idNelayan = Integer.parseInt(inventory_idNelayanField.getText());

            Ikan ikan = new Ikan(0, nama, harga, gambar, stok, idNelayan);
            adminDAO.addIkan(ikan); // Tambahkan data ke database
            loadInventoryData();
            clearInventoryFields();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Data ikan berhasil ditambahkan.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Terjadi kesalahan saat menambahkan data ikan.");
        }
    }

    private void updateIkan() {
        try {
            Ikan selectedIkan = inventory_table.getSelectionModel().getSelectedItem();
            if (selectedIkan == null) {
                showAlert(Alert.AlertType.ERROR, "Selection Error", "Pilih ikan yang ingin diperbarui.");
                return;
            }

            String nama = inventory_namaField.getText();
            double harga = Double.parseDouble(inventory_hargaField.getText());
            String gambar = inventory_gambarField.getText();
            int stok = Integer.parseInt(inventory_stokField.getText());
            int idNelayan = Integer.parseInt(inventory_idNelayanField.getText());

            selectedIkan.setnamaIkan(nama);
            selectedIkan.setHarga(harga);
            selectedIkan.setGambarIkan(gambar);
            selectedIkan.setStok(stok);
            selectedIkan.setIdNelayan(idNelayan);

            adminDAO.updateIkan(selectedIkan); // Perbarui data di database
            loadInventoryData();
            clearInventoryFields();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Data ikan berhasil diperbarui.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Terjadi kesalahan saat memperbarui data ikan.");
        }
    }

    private void deleteIkan() {
        try {
            Ikan selectedIkan = inventory_table.getSelectionModel().getSelectedItem();
            if (selectedIkan == null) {
                showAlert(Alert.AlertType.ERROR, "Selection Error", "Pilih ikan yang ingin dihapus.");
                return;
            }

            adminDAO.deleteIkan(selectedIkan.getIdIkan()); // Hapus data dari database
            loadInventoryData();
            clearInventoryFields();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Data ikan berhasil dihapus.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Terjadi kesalahan saat menghapus data ikan.");
        }
    }

    private void clearInventoryFields() {
        inventory_namaField.clear();
        inventory_hargaField.clear();
        inventory_gambarField.clear();
        inventory_stokField.clear();
        inventory_idNelayanField.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

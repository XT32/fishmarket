/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
/**
 *
 * @author imdaq
 */
public class adminViewController implements Initializable{
    
    @FXML
    private Button Inventory_deleteButton;

    @FXML
    private AnchorPane adminView;
    
    @FXML
    private Button customer_button;

    @FXML
    private Button dashboard_button;

    @FXML
    private Button display_button;

    @FXML
    private TableColumn<?, ?> inventory_IDikan;

    @FXML
    private Button inventory_annButton;

    @FXML
    private Button inventory_button;

    @FXML
    private Button inventory_clearButton;

    @FXML
    private AnchorPane inventory_form;

    @FXML
    private ImageView inventory_image_view;

    @FXML
    private Button inventory_importButton;

    @FXML
    private TableColumn<?, ?> inventory_jenisIkan;

    @FXML
    private TableColumn<?, ?> inventory_namaIkan;

    @FXML
    private TableColumn<?, ?> inventory_status;

    @FXML
    private TableColumn<?, ?> inventory_stok;

    @FXML
    private TableView<?> inventory_table;

    @FXML
    private TableColumn<?, ?> inventory_tanggalDitambahkan;

    @FXML
    private Button inventory_updateButton;

    @FXML
    private Button logout_button;
    
    public void displayUsername(){
    
    }
   
    public void Initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

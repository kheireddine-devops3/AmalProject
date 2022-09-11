package com.amal.amalproject.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestionAideController {

    @FXML
    private TextArea TxtPublication;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModif;

    @FXML
    private Button btnSupp;

    @FXML
    private Button btnVider;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> demande;

    @FXML
    private TableColumn<?, ?> sujet;

    @FXML
    private TableView<?> tableAide;

    @FXML
    private TextField txtSujet;

    @FXML
    void Ajouter(ActionEvent event) {

    }

    @FXML
    void Modifier(ActionEvent event) {

    }

    @FXML
    void Supprimer(ActionEvent event) {

    }

    @FXML
    void vider(ActionEvent event) {

    }

}


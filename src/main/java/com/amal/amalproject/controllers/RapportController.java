package com.amal.amalproject.controllers;

import com.amal.amalproject.MainApplication3;
import com.amal.amalproject.entities.Rapport;
import com.amal.amalproject.models.RapportModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RapportController {

    @FXML
    public Button btnretour;

    @FXML
    public ImageView imgR;

    @FXML
    public TextField nomR;

    @FXML
    public TextField prenomR;

    @FXML
    public TextField mailR;

    @FXML
    public TextField numR;

    @FXML
    public TextField sujetR;

    @FXML
    public TextArea descR;

    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    RapportModel rapportModel = new RapportModel();


    public void btnRetourClicked (ActionEvent event) {

        try {

            if (event.getSource() == btnretour) {
                stage = (Stage) btnretour.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication3.class.getResource("Home.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void btnEnvoyerClicked (){
        String nom = nomR.getText();
        String prenom = prenomR.getText();
        String mail = mailR.getText();
        String numTel = numR.getText();
        String sujet = sujetR.getText();
        String description = descR.getText();

        Rapport rp = new Rapport(nom, prenom, mail, numTel, sujet, description);


        rapportModel.addRapport(rp);
        nomR.getText();
        prenomR.getText();
        mailR.getText();
        numR.getText();
        sujetR.getText();
        descR.getText();

    }

}

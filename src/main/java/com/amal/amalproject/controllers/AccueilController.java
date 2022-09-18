package com.amal.amalproject.controllers;



import com.amal.amalproject.MainApplication3;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.stage.StageStyle;

public class AccueilController implements Initializable {



    private Parent root;

    @FXML
    protected Button BAjouter,BAccueil,BModifier,BSupprimer,btnretour;

    @FXML
    private ImageView x;

    @FXML
    private ImageView homeIcon;

    @FXML
    private ImageView addIcon;

    @FXML
    private ImageView modifyIcon;

    @FXML
    private ImageView removeIcon;

    @FXML
    private Stage stage;





    @FXML
    public void goToAccueil(ActionEvent event) {

        try {

            if (event.getSource() == BAccueil) {
                stage = (Stage) BAccueil.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication3.class.getResource("Accueil.fxml"));
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

    public void goToAjouter (ActionEvent event) {

        try {

            if (event.getSource() == BAjouter) {
                stage = (Stage) BAjouter.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication3.class.getResource("Ajouter.fxml"));
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

    public void goToModifier (ActionEvent event){

        try {

            if (event.getSource() == BModifier) {
                stage = (Stage) BAccueil.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication3.class.getResource("Modifier.fxml"));
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

    public void goToSupprimer (ActionEvent event)  {

        try {

            if (event.getSource() == BSupprimer) {
                stage = (Stage) BAccueil.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication3.class.getResource("Supprimer.fxml"));
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
    public void exit(){

    }

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





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

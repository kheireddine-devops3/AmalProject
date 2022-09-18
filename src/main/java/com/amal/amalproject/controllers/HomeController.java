package com.amal.amalproject.controllers;

import com.amal.amalproject.MainApplication3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeController {




    @FXML
    public ImageView imageF;

    @FXML
    public ImageView amal;

    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    @FXML
    public Button btndon;

    @FXML
    public Button btnrapport;



    public void btndonclicked (ActionEvent event)  {

        try {

            if (event.getSource() == btndon) {
                stage = (Stage) btndon.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication3.class.getResource("Accueil.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.  show();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void btnrapportclicked (ActionEvent event)  {

        try {

            if (event.getSource() == btnrapport) {
                stage = (Stage) btnrapport.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication3.class.getResource("rapport.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 500, 600);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.  show();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}

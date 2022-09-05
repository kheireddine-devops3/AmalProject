package com.amal.amalproject.controllers;

import java.io.IOException;

import com.amal.amalproject.MainApplication;
import com.amal.amalproject.utils.Navigate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class firstController {
	@FXML
    private Button btngo;

    @FXML
    void goSecond(ActionEvent event) throws IOException {
    	
        Navigate.changerScene(event, "AddEmploi.fxml", "Ajouter une offre d'emploi");
    }
}

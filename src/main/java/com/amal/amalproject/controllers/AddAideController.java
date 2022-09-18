package com.amal.amalproject.controllers;

import com.amal.amalproject.entities.Aide;
import com.amal.amalproject.entities.User;
import com.amal.amalproject.models.AideModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class AddAideController {
	
    @FXML
    private Button addAide;

    @FXML
    private TextArea pubContenue;

    @FXML
    private TextField pubSujet;
    
    @FXML
    private Button vider;

    
    private AideModel aideModel = new AideModel();
    
    @FXML
    protected  void onAddAideClick(ActionEvent Click) {
    	String contenue = pubContenue.getText();
    	String sujet = pubSujet.getText();
        Aide aide = new Aide(contenue,sujet);
       this.aideModel.AddAide(aide);
       pubContenue.clear();
   	pubSujet.clear();

    }
    @FXML
    
    void vider(ActionEvent event) {
    	pubContenue.clear();
    	pubSujet.clear();

    }
}

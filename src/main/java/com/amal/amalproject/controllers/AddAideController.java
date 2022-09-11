package com.amal.amalproject.controllers;

import com.amal.amalproject.entities.Aide;
import com.amal.amalproject.entities.User;
import com.amal.amalproject.models.AideModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class AddAideController {
	@FXML
    private Label errorsujet;

    @FXML
    private Label errortxt;
	
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
    	if(isValid()) {
    	String contenue = pubContenue.getText();
    	String sujet = pubSujet.getText();
        Aide aide = new Aide(contenue,sujet);
       this.aideModel.AddAide(aide);
       pubContenue.clear();
   	   pubSujet.clear();
   	   
   	   
      
    	}
    }
    @FXML
    
    void vider(ActionEvent event) {
    	pubContenue.clear();
    	pubSujet.clear();

    }
    private boolean isValid(){
    	boolean sujetValid=false;
    	boolean txtValid=false;
    	if(pubSujet.getText().isBlank()) {
    		errorsujet.setText("Merci d'indiquer votre sujet");
    	}else {
    		errorsujet.setText("");
    		sujetValid = true;
    	}
    	if(pubContenue.getText().isBlank()) {
    		errortxt.setText("Merci d'indiquer votre sujet");
    		sujetValid = false;
    	}else {
    		errortxt.setText("");
    		txtValid = true;
    	}
    	return (sujetValid && txtValid);
    	
    }
}

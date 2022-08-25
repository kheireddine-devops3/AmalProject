package com.amal.amalproject.controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.amal.amalproject.entities.Emploi;
import com.amal.amalproject.entities.User;
import com.amal.amalproject.models.EmploiModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddEmploiController {
	private EmploiModel em =new EmploiModel();
	 @FXML
	    private AnchorPane Apid;

	    @FXML
	    private Button btnok;

	    @FXML
	    private Button btnAnnuler;

	    @FXML
	    private TextField txtref;

	    @FXML
	    private TextField txttitre;

	    @FXML
	    private TextField txtsecteur;

	    @FXML
	    private DatePicker dateExp;

	    @FXML
	    private TextArea txtdesc;


    
    
    @FXML
    void onClick(ActionEvent event) {
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
    	String titre =txttitre.getText();
    	String secteur=txtsecteur.getText();
    	String ref =txtref.getText();
    	Date dateexp= java.sql.Date.valueOf(dateExp.getValue());
    	String desc =txtdesc.getText();
 
    	Emploi e =new Emploi(titre,desc,secteur,ref,dateexp);
    	em.add(e);
    	 for (Emploi emp: em.readAll()) {
             System.out.println(emp);
         }
      System.out.println("it works"); 
    }
   

}

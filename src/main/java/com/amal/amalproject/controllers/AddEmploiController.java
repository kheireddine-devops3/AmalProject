package com.amal.amalproject.controllers;

import com.amal.amalproject.entities.Emploi;
import com.amal.amalproject.entities.User;
import com.amal.amalproject.models.EmploiModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddEmploiController {

    @FXML
    private TextField txttitre;

    @FXML
    private TextField txtsecteur;

    @FXML
    private TextField txtref;

    @FXML
    private TextField txtdate;

    @FXML
    private TextArea txtdesc;

    @FXML
    private Button btnadd;
    
    private EmploiModel em =new EmploiModel();
    @FXML
    void onAddEmploiClick(ActionEvent event) {
    	String titre =txttitre.getText();
    	String secteur=txtsecteur.getText();
    	String ref =txtref.getText();
    	String date =txtdate.getText();
    	String desc =txtdesc.getText();
 
    	Emploi e =new Emploi(titre,desc,secteur,ref,date);
    	em.add(e);
    	 for (Emploi emp: em.readAll()) {
             System.out.println(emp);
         }
       
    }

}

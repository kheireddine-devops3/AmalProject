package com.amal.amalproject.controllers;


	import java.io.IOException;
import java.sql.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
	import javafx.scene.control.DatePicker;
	import javafx.scene.layout.Pane;
import javafx.stage.Stage;

	public class  CalenderController{

	    @FXML
	    private Pane panelid;

	    @FXML
	    private DatePicker daten;

	    @FXML
	    private Button btnok;
	    @FXML
	    void OnOkClick(ActionEvent event) throws IOException {
	    	//Date datenai= java.sql.Date.valueOf(daten.getValue());
	    	//System.out.println(datenai.toString());
          
            
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("AddEmploi.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            
            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableViewScene);
            window.show();
	    }

	}



package com.amal.amalproject.controllers;


	import java.sql.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.DatePicker;
	import javafx.scene.layout.Pane;

	public class  CalenderController{

	    @FXML
	    private Pane panelid;

	    @FXML
	    private DatePicker daten;

	    @FXML
	    private Button btnok;
	    @FXML
	    void OnOkClick(ActionEvent event) {
	    	Date datenai= java.sql.Date.valueOf(daten.getValue());
	    	System.out.println(datenai.toString());
	    }

	}



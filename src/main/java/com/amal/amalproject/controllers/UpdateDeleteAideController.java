package com.amal.amalproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.amal.amalproject.entities.Aide;
import com.amal.amalproject.models.AideModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateDeleteAideController implements Initializable{

    @FXML
    private Button btnModif;

    @FXML
    private Button btnfind;
    
    @FXML
    private Button btncom;

    @FXML
    private Button btnsup;

    @FXML
    private Label label;

    @FXML
    private TextArea txtcontenue;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtsujet;

    @FXML
    void modifier(ActionEvent event) {
    	String ida = txtid.getText();
    	int id = Integer.parseInt(ida);
    	String contenue = txtcontenue.getText();
    	String sujet = txtsujet.getText();
    	Aide aide =new Aide();
    	aide.setIdAide(id);
    	aide.setContenue(contenue);
    	aide.setSujet(sujet);
    	int status = AideModel.UpdateAide(aide);
    	txtcontenue.clear();
    	txtsujet.clear();
    	txtid.clear();
    }

    @FXML
    void supprimer(ActionEvent event) {
    	String ida = txtid.getText();
    	int id = Integer.parseInt(ida);
    	int status=AideModel.DeleteAide(id);

    }

    @FXML
    void trouver(ActionEvent event) {
    
    	String ida = txtid.getText();
    	int id = Integer.parseInt(ida);
    	Aide aide = AideModel.GetId(id);
    	txtsujet.setText(aide.getSujet());
    	txtcontenue.setText(aide.getContenue());
    	String contenue =aide.getContenue();
    	System.out.println("bonjour" +contenue);
    	System.out.println("bonjour" +id);

    }
    
    @FXML
    void onAfficheCommentaire(ActionEvent event) throws IOException {
    	String ida = txtid.getText();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/amal/amalproject/show-commentaires-view.fxml"));
		Parent root = (Parent) loader.load();
		 ShowCommentaireAideController controller =loader.getController();
		 controller.GetIddemande(ida);
		 Scene scene = new Scene(root);
		 Stage stage = new Stage();
		 stage.setScene(scene);
		 stage.show();

    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

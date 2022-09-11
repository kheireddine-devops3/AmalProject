package com.amal.amalproject.controllers;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.amal.amalproject.entities.CommentaireAide;
import com.amal.amalproject.utils.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ShowCommentaireAideController implements Initializable {
	  @FXML
	    private Label txtdemande;

	    @FXML
	    private Label txtsujet;
    @FXML
    private Button btnAfficherCommentaire;

    @FXML
    private TableColumn<CommentaireAide, String> commentaire;

    @FXML
    private TableColumn<CommentaireAide, Date> datecom;

    @FXML
    private TableColumn<CommentaireAide, Integer> idcom;

    @FXML
    private AnchorPane tablecom;

    @FXML
    private TableView<CommentaireAide> tablecommentaire;

    @FXML
    private Label txtaide;
    ObservableList<CommentaireAide> obs = FXCollections.observableArrayList();
    
    public void GetIddemande(String ida, String sujet, String contenue) {
        txtaide.setText(ida);
        txtsujet.setText(sujet);
        txtdemande.setText(contenue);
    }
   
	
    
    public void onShowclick(int id) {
    	obs.clear();
    	
	try {
    		Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM commentaireaide WHERE idDemandeAide=?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            
            if(resultSet.next()) {
                  int idCommentaire = resultSet.getInt("idCommentaire");
	              String txtCommentaire = resultSet.getString("txtCommentaire");
	              LocalDate dateCommentaire = resultSet.getDate("dateCommentaire") != null ? resultSet.getDate("dateCommentaire").toLocalDate() : null;
                  int idCompte = resultSet.getInt("idCompte");
	              int idDemande = resultSet.getInt("idDemandeAide");

                obs.add(new CommentaireAide(idCommentaire, txtCommentaire, dateCommentaire, idCompte, idDemande));
            }else {
            	 Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Aucun Commentaire!");
                	alert.setHeaderText("Information");
                	alert.setContentText("Ooops! Aucun Commentaire à afficher");
                	alert.showAndWait();
            }
        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
	    idcom.setCellValueFactory(new PropertyValueFactory<CommentaireAide, Integer>("idCommentaire"));
        datecom.setCellValueFactory(new PropertyValueFactory<CommentaireAide, Date>("dateCommentaire"));
        commentaire.setCellValueFactory(new PropertyValueFactory<CommentaireAide, String>("txtCommentaire"));
        tablecommentaire.setItems(obs);
    }

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 String ida = txtaide.getText();
			int  iddemande = Integer.parseInt(ida);
			System.out.println("bonjour" +iddemande);
		
		 
		
		
	}

}


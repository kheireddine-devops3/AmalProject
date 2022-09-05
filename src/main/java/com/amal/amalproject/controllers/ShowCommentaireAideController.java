package com.amal.amalproject.controllers;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.amal.amalproject.entities.CommentaireAide;
import com.amal.amalproject.utils.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ShowCommentaireAideController {

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
    
    public void GetIddemande(String id) {
        txtaide.setText(id);
    }
    
    @FXML
    void onShowclick(ActionEvent event) {
    	obs.clear();
    	String ida = txtaide.getText();
 	    int  iddemande = Integer.parseInt(ida);
	try {
    		Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM commentaireaide WHERE idDemandeAide=?");
            ps.setInt(1, iddemande);
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

}



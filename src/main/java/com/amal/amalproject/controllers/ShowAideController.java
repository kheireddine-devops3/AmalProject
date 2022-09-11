package com.amal.amalproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.amal.amalproject.entities.Aide;
import com.amal.amalproject.entities.Compte;
import com.amal.amalproject.utils.DBConnection;
import com.amal.amalproject.utils.SessionUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShowAideController extends SharedController implements Initializable {
	
	 @FXML
	    private  TextField txtlogin;
	  @FXML
	    private TextField IdUser;
    @FXML
    private Button btnShowaide;
    @FXML
    private Button btnajout;

    @FXML
    private Button btnmodif;

    @FXML
    private TableColumn<Aide, Date> datePublication;

    @FXML
    private TableColumn<Aide, Integer> idDemande;

    @FXML
    private TableColumn<Aide, Integer> user;

    @FXML
    private TableColumn<Aide, Integer> commentaire;

    @FXML
    private TableColumn<Aide, Integer > compte;

    @FXML
    private TableColumn<Aide, String> contenue;

    @FXML
    private TableColumn<Aide, String> sujet;

    @FXML
    private TableView<Aide> tableAide;
    ObservableList<Aide> obs = FXCollections.observableArrayList();
    public void GetidUser(String id,String login){
    	
    	txtlogin.setText(login);
    	IdUser.setText(id);	
    	
     }
   
    
      public  void tableAide() {
    	obs.clear();
    	
      	 
    	try {
    		
    		Connection connection = DBConnection.getConnection();
    		
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM demandeaide WHERE id_user=3");
         
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

        int idAide = resultSet.getInt("id_demande_aide");
	String contenue = resultSet.getString("contenue");
	LocalDate datePublication = resultSet.getDate("date_publication") != null ? resultSet.getDate("date_publication").toLocalDate() : null;
	String sujet = resultSet.getString("sujet");
	int idUser = resultSet.getInt("id_user");

                obs.add(new Aide(idAide, contenue, datePublication,sujet,idUser));

            }
           

        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

       

        idDemande.setCellValueFactory(new PropertyValueFactory<Aide, Integer>("idAide"));
        datePublication.setCellValueFactory(new PropertyValueFactory<Aide, Date>("datePublication"));
        contenue.setCellValueFactory(new PropertyValueFactory<Aide, String>("contenue"));
        sujet.setCellValueFactory(new PropertyValueFactory<Aide, String>("sujet"));
       
        
        tableAide.setItems(obs);

    }
    @FXML
    void onloadAjout(ActionEvent event) throws IOException {
    	
    	Stage stage = new Stage();
		 Parent root = FXMLLoader.load(getClass().getResource("/com/amal/amalproject/add-aide-view.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
    

    }

    @FXML
    void onloadModif(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
		 Parent root = FXMLLoader.load(getClass().getResource("/com/amal/amalproject/updatedelete-aide-view.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();

    }
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tableAide();
		Compte compte = SessionUtils.getCurrentUser();
	
		
	}

}

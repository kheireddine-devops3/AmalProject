package com.amal.amalproject.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Collation;

import com.amal.amalproject.MainApplication;
import com.amal.amalproject.entities.Formation;
import com.amal.amalproject.entities.User;
import com.amal.amalproject.models.FormationModel;
import com.amal.amalproject.models.IFormationModel;

import javafx.scene.control.cell.PropertyValueFactory;
import com.amal.amalproject.models.UserModel;
import com.amal.amalproject.utils.DBConnection;

import javafx.scene.control.TextField;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.TextArea;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import javafx.scene.control.TableView;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import com.amal.amalproject.utils.DBConnection;

public class GestionFormationController implements Initializable {

	@FXML
	private AnchorPane dateformation;
	@FXML
	private TableView<Formation> formationTableView;
	@FXML
	private TableColumn<Formation, Integer> id_col;
	@FXML
	private TableColumn<Formation, LocalDate> date_col;
	@FXML
	private TableColumn<Formation, String> theme_col;
	@FXML
	private TableColumn<Formation, String> detail_col;
	@FXML
	private TextField theme;
	@FXML
	private TextArea descriptif;
	@FXML
	private DatePicker Date_publication;
	@FXML
	private Button btnBack;
	@FXML
	private Button back;
	@FXML
	private Stage stage;

	FormationModel formationModel = new FormationModel();
	int ID;
	ObservableList<Formation> formations = FXCollections.observableArrayList();

	// button AJOUTER

	@FXML
	public void btnAjouter_clicked(ActionEvent event) {

		String FormationTheme = theme.getText();
		String FormationDescriptif = descriptif.getText();
		LocalDate date = Date_publication.getValue();
		formationTableView.refresh();
		System.out.print("ASMA date==> " + date);
		Formation formation = new Formation(FormationTheme, FormationDescriptif, date);
		formationModel.addFormation(formation);
		theme.getText();
		descriptif.getText();
		Date_publication.getValue();
		formationTableView.setItems(formationModel.getAllFormation());

	}

	// Event Listener on Button.onAction
	@FXML
	public void btnSupprimer_clicked(ActionEvent event) {
		Formation fr = (Formation) formationTableView.getSelectionModel().getSelectedItem();
		if (fr == null) {
			System.out.println("aucune formation a supprimer !");
			return;
		}
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Supression d'une formation !");
		alert.setContentText("Etes vous totalement sur de vouloir supprimer une formation <" + fr.getId_formation()
				+ "-" + fr.getTheme() + "> ??\n");
		alert.getDialogPane().setMinHeight(ID);
		alert.setHeight(400);
		Optional<ButtonType> reponse = alert.showAndWait();
		if (reponse.get().equals(ButtonType.OK)) {
			try {
				Connection connection = DBConnection.getConnection();
				Statement sqlCommand = connection.createStatement();
				sqlCommand.execute(

						("Delete  FROM `formation` WHERE `id_formation` = " +

								fr.getId_formation()));

				formationTableView.getItems().remove(formationTableView.getSelectionModel().getSelectedItem());
				formationTableView.refresh();
				theme.setText("");
				descriptif.setText("");
				Date_publication.setValue(null);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// EVENT AFFICHAGE BASE AU GRAFIC
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		// reference de chaque coloune avec son valeur dans la base
		id_col.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));
		theme_col.setCellValueFactory(new PropertyValueFactory<Formation, String>("theme"));
		detail_col.setCellValueFactory(new PropertyValueFactory<Formation, String>("descriptif"));
		date_col.setCellValueFactory(new PropertyValueFactory<Formation, LocalDate>("Date_publication"));

		formationTableView.setItems(formationModel.getAllFormation());

		System.out.print("*".repeat(50));
		formationModel.getAllFormation().forEach(System.out::println);
		System.out.print("*".repeat(50));

	}

	// bouton RETOUR EN arriére
	@FXML
	public void Back(Event e) {
		try {
			// add you loading or delays - ;-)
			Node node = (Node) e.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();

		} catch (Exception ex) {
			System.out.println("y" + ex.getMessage());
		}

	}
	
	
	@FXML
	public void backCLICK(ActionEvent event) {

		try {

			if (event.getSource() == back) {
				stage = (Stage) back.getScene().getWindow();

				FXMLLoader fxmlLoader = new FXMLLoader(
						MainApplication.class.getResource("ProfilFormation.fxml"));
				Scene scene = new Scene(fxmlLoader.load(), 800, 600);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.initStyle(StageStyle.UTILITY);
				stage.show();
			}
		} catch (IOException ex) {
			Logger.getLogger(ProfilFormation.class.getName()).log(Level.SEVERE, null, ex);

		}
	}


	@FXML
	public void btnModifier_clicked(ActionEvent event) {

		Formation formation = new Formation();

		if (!theme.getText().equals("") && !descriptif.getText().equals("")
				&& !Date_publication.getValue().equals("")) {

			formation.setTheme(theme.getText());
			formation.setDescriptif(descriptif.getText());
			formation.setDate_publication((Date_publication.getValue()));
			formation.setId_formation(ID);

			formationModel.updateFormation(formation);
			formationTableView.setItems(formationModel.getAllFormation());
			formationTableView.refresh();

			theme.setText("");
			descriptif.setText("");
			Date_publication.setValue(null);

			System.out.println("affichage de modification 2" + formationModel.getAllFormation());

		}

	}

	// selection des lignes

	public void clickTable(Event e) {
		Formation formation = (Formation) formationTableView.getSelectionModel().getSelectedItem();
		theme.setText(formation.getTheme());
		descriptif.setText(formation.getDescriptif() + "");
		Date_publication.setValue(formation.getDate_publication());
		ID = formation.getId_formation();

	}

}

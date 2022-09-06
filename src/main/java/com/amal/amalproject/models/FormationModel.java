package com.amal.amalproject.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.amal.amalproject.entities.Formation;
import com.amal.amalproject.entities.User;
import com.amal.amalproject.utils.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FormationModel implements IFormationModel {
	Statement state;
	Connection connection = DBConnection.getConnection();

//ajout dan la base 
	@Override
	public void addFormation(Formation formation) {
		// TODO Auto-generated method stub

		try {

			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO formation(" + "id_formation,theme,descriptif,Date_publication) VALUES (?,?,?,?)"

			);

			ps.setInt(1, formation.getId_formation());
			// TEST ID

			ps.setString(2, formation.getTheme());
			ps.setString(3, formation.getDescriptif());

			if (formation.getDate_publication() != null)
				ps.setDate(4, Date.valueOf(formation.getDate_publication()));
			else
				ps.setDate(4, null);

			int n = ps.executeUpdate();

		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}

	}

	// return all data as observable list because table parmetar is observable

	public ObservableList<Formation> getAllFormation() {

		ObservableList<Formation> formations = FXCollections.observableArrayList();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM formation;");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				// si définir l'objet pendant que stockera la dernière ligne n foi

				Formation fr = new Formation();

				fr.setId_formation(resultSet.getInt(1));

				fr.setTheme(resultSet.getString(2));

				fr.setDescriptif(resultSet.getString(3));

				Date date = resultSet.getDate(4);

				if (date != null) {
					fr.setDate_publication(date.toLocalDate());
				} else {
					System.out.println("la date est null");
				}

				System.out.println("============> " + fr);

				formations.add(fr);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		}
		System.out.println("tous les formations" + formations);
		return formations;

	}

	// modifier formation dans la base
	@Override
	public void updateFormation(Formation formation) {

		try {

			PreparedStatement ps = connection.prepareStatement("UPDATE formation set   theme = " + "'"
					+ formation.getTheme() + "'" + ", descriptif = " + "'" + formation.getDescriptif() + "'"
					+ ", Date_publication = " + "'" + formation.getDate_publication() + "'" + ""
					+ " WHERE id_formation = " + formation.getId_formation()

			);

			int n = ps.executeUpdate();

		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}

	}

}

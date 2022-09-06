package com.amal.amalproject.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.amal.amalproject.entities.Formation;
import com.amal.amalproject.entities.Video;
import com.amal.amalproject.utils.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TutorielModel extends FormationModel implements ITutorielModel {
	Statement state;
	Connection connection = DBConnection.getConnection();

	// return all data as observable list because table parmetar is observable

	

	@Override
	public void addTutoriel(Video video) {
		// TODO Auto-generated method stub
		
		 try {

	            PreparedStatement ps = connection.prepareStatement
	            		("INSERT INTO video("
	            				+ "id_video,nom,url) VALUES (?,?,?,?)"
	            				
	            				);
	            
	             ps.setInt(1,video.getId_video());
	            ps.setString(2,video.getNom());
	            ps.setString(3,video.getUrl());
	           
	            ps.setInt(4,video.getId_formation());
	        
	            int n = ps.executeUpdate();

	        } catch (SQLException exception) {
	            System.out.println(exception.getMessage());
	        }
		
		
		
		
		

	}

	@Override
	public void updateTutoriel(Video video) {
		
		 try {

	            PreparedStatement ps = connection.prepareStatement
	            		("UPDATE video set   nom = " +"'"+video.getNom()+"'" +
       		              ", url = " +"'"+ video.getUrl() 
       	    	+ " WHERE id_formation = "+video.getId_video() 
     				
	            				);
	  
	            int n = ps.executeUpdate();

	        } catch (SQLException exception) {
	            System.out.println(exception.getMessage());
	        }
	
		
		

	}

	@Override
	public List<Video> getAllVideo() {
		// TODO Auto-generated method stub


		ObservableList<Video> video = FXCollections.observableArrayList();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM video;");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				// si définir l'objet pendant que stockera la dernière ligne n foi

				Video v = new Video();
				v.setId_video(resultSet.getInt(1));

				v.setNom(resultSet.getString(2));

				v.setUrl(resultSet.getString(3));
				v.setId_formation(resultSet.getInt(4));

				System.out.println("============> " + v);

				video.add(v);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		}
		System.out.println("tous les video" + video);
		return video;
		
		
		
		
	}

}

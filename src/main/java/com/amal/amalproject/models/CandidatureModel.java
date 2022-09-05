package com.amal.amalproject.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import com.amal.amalproject.entities.Candidature;
import com.amal.amalproject.utils.DBConnection;
public class CandidatureModel implements Iservice<Candidature>{
	Connection connection = DBConnection.getConnection();
	@Override
	public void add(Candidature t) {
		// TODO Auto-generated method stub
		try {

			PreparedStatement ps = connection.prepareStatement("INSERT INTO candidatures(ID_EMPLOI,ID_COMPTE,DATE_CANDIDATURE,URL_CV,NIVEAU) VALUES (?,?,?,?,?)");
			LocalDate todaysDate = LocalDate.now();
	        Date date = java.sql.Date.valueOf(todaysDate);

			ps.setInt(1,t.getId_emploi());
			ps.setInt(2,1);
			ps.setDate(3,date);
			ps.setString(4, t.getUrl_cv());
			ps.setString(5, t.getNiveau());
			
			int n = ps.executeUpdate();
           System.out.println(n);
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}

	}

	@Override
	public void delete(Candidature t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Candidature readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Candidature> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Candidature t) {
		// TODO Auto-generated method stub
		
	}

}

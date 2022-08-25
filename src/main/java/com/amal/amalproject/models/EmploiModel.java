package com.amal.amalproject.models;
import com.amal.amalproject.entities.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.amal.amalproject.utils.*;
public class EmploiModel implements Iservice <Emploi>{
	
	 Connection connection = DBConnection.getConnection();
	@Override
	public void add(Emploi t) {
		  try {
			   
	            PreparedStatement ps = connection.prepareStatement("INSERT INTO emplois(ID_EMPLOI,TITRE_EMPLOI,DESCRIPTIF_EMPLOI,SECTEUR,REF_EMPLOI,DATE_EXPIRATION,ID_COMPTE) VALUES (NULL,?,?,?,?,?,NUll)");

	            ps.setString(1,t.getTitre_emploi());
	            ps.setString(2,t.getDescriptif_emploi());
	            ps.setString(3,t.getSecteur());
	            ps.setString(4, t.getRef_emploi());
	            ps.setDate(5, t.getDate_expiration());
	           
	         //  ps.setString(5, t.getDate_expiration());

	            int n = ps.executeUpdate();

	        } catch (SQLException exception) {
	            System.out.println(exception.getMessage());
	        }
	       
	    }

	@Override
	public void delete(Emploi t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Emploi readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Emploi> readAll() {
		ArrayList<Emploi> emplois = new ArrayList<Emploi>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM emplois;");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int id_emploi = resultSet.getInt("id_emploi");
                String titre_emploi = resultSet.getString("titre_emploi");
                String descriptif_emploi = resultSet.getString("descriptif_emploi");
                String secteur = resultSet.getString("secteur");
                String ref_emploi = resultSet.getString("ref_emploi");
                Date date_expiration = resultSet.getDate("date_expiration");
               
                emplois.add(new Emploi (titre_emploi, descriptif_emploi,secteur,ref_emploi,(java.sql.Date) date_expiration));

            }

        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return emplois;
    }
	

	@Override
	public void update(Emploi t) {
		// TODO Auto-generated method stub
		
	}

}

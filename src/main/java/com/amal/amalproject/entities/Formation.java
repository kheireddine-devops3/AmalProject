package com.amal.amalproject.entities;

import java.sql.Date;

public class Formation {
	private int id_formation;
    private String theme;
    private String descriptif;
    private Date Date_publication;
	
    
    public Formation() {
		super();
	}
    
    
	public Formation(int id_formation, String theme, String descriptif, Date date_publication) {
		super();
		this.id_formation = id_formation;
		this.theme = theme;
		this.descriptif = descriptif;
		Date_publication = date_publication;
	}


	public int getId_formation() {
		return id_formation;
	}


	public void setId_formation(int id_formation) {
		this.id_formation = id_formation;
	}


	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
	}


	public String getDescriptif() {
		return descriptif;
	}


	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}


	public Date getDate_publication() {
		return Date_publication;
	}


	public void setDate_publication(Date date_publication) {
		Date_publication = date_publication;
	}
	
	
    
    

}

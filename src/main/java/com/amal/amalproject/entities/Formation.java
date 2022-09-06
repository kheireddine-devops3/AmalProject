package com.amal.amalproject.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;


public class Formation {
    private int id_formation;
    private String theme;
    private String descriptif;
    private LocalDate Date_publication;
    String project;
    public Formation() {
    }
    
    public Formation(String theme, String descriptif) {
      
        this.theme = theme;
        this.descriptif = descriptif;
     
    }
    public Formation(String theme, String descriptif,LocalDate Date_publication) {
        
        this.theme = theme;
        this.descriptif = descriptif;
        this.Date_publication = Date_publication;
     
    }
    public Formation(int id_formation, String theme, String descriptif) {
        this.id_formation = id_formation;
        this.theme = theme;
        this.descriptif = descriptif;
     
    }
    public Formation(int id_formation, String theme, String descriptif, LocalDate date_publication) {
        this.id_formation = id_formation;
        this.theme = theme;
        this.descriptif = descriptif;
        this.Date_publication = date_publication;
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

    public LocalDate getDate_publication() {
		return  Date_publication;
	}

    public void setDate_publication(LocalDate localDate) {
		Date_publication = localDate;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formation)) return false;
        Formation formation = (Formation) o;
        return getId_formation() == formation.getId_formation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_formation());
    }

    @Override
    public String toString() {
        return "formation{" +
                "id_formation=" + id_formation +
                ", theme='" + theme + '\'' +
                ", descriptif='" + descriptif + '\'' +
                ", Date_publication=" + Date_publication +
                '}';
    }
   
}
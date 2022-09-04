package com.amal.amalproject.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Aide {
	private int idAide;
	private String contenue;
	private LocalDate datePublication;
	private String sujet;
	private int idUser;
	
	
	public Aide() {
		
	}


	public Aide(String contenue, LocalDate datePublication, String sujet) {
		
		this.contenue = contenue;
		this.datePublication = datePublication;
		this.sujet = sujet;
	}
	


	public Aide(String contenue, String sujet) {
		
		this.contenue = contenue;
		this.sujet = sujet;
	}


	public Aide(int idAide, String contenue, LocalDate datePublication, String sujet, int idUser) {
		
		this.idAide = idAide;
		this.contenue = contenue;
		this.datePublication = datePublication;
		this.sujet = sujet;
		this.idUser = idUser;
	}


	public int getIdAide() {
		return idAide;
	}


	public void setIdAide(int idAide) {
		this.idAide = idAide;
	}


	public String getContenue() {
		return contenue;
	}


	public void setContenue(String contenue) {
		this.contenue = contenue;
	}


	public LocalDate getDatePublication() {
		return datePublication;
	}


	public void setDatePublication(LocalDate datePublication) {
		this.datePublication = datePublication;
	}


	public String getSujet() {
		return sujet;
	}


	public void setSujet(String sujet) {
		this.sujet = sujet;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	@Override
	public int hashCode() {
		return Objects.hash(contenue, datePublication, idAide, idUser, sujet);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aide other = (Aide) obj;
		return Objects.equals(contenue, other.contenue) && Objects.equals(datePublication, other.datePublication)
				&& idAide == other.idAide && idUser == other.idUser && Objects.equals(sujet, other.sujet);
	}


	@Override
	public String toString() {
		return "Aide [idAide=" + idAide + ", contenue=" + contenue + ", datePublication=" + datePublication + ", sujet="
				+ sujet + ", idUser=" + idUser + "]";
	}
	
	

}


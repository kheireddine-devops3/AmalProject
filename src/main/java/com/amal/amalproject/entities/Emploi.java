package com.amal.amalproject.entities;

import java.sql.Date;
import java.time.LocalDate;

public class Emploi {
	
    private int id_emploi;
    private String titre_emploi;
    private String descriptif_emploi;
    private String secteur;
    private String ref_emploi;
    private Date date_expiration;
	public int getId_emploi() {
		return id_emploi;
	}
	public void setId_emploi(int id_emploi) {
		this.id_emploi = id_emploi;
	}
	public String getTitre_emploi() {
		return titre_emploi;
	}
	public void setTitre_emploi(String titre_emploi) {
		this.titre_emploi = titre_emploi;
	}
	public String getDescriptif_emploi() {
		return descriptif_emploi;
	}
	public void setDescriptif_emploi(String descriptif_emploi) {
		this.descriptif_emploi = descriptif_emploi;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	public String getRef_emploi() {
		return ref_emploi;
	}
	public void setRef_emploi(String ref_emploi) {
		this.ref_emploi = ref_emploi;
	}
	public Date getDate_expiration() {
		return date_expiration;
	}
	public void setDate_expiration(Date date_expiration) {
		this.date_expiration = date_expiration;
	}
	@Override
	public String toString() {
		return "Emploi [id_emploi=" + id_emploi + ", titre_emploi=" + titre_emploi + ", descriptif_emploi="
				+ descriptif_emploi + ", secteur=" + secteur + ", ref_emploi=" + ref_emploi + ", date_expiration="
				+ date_expiration + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ref_emploi == null) ? 0 : ref_emploi.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emploi other = (Emploi) obj;
		if (ref_emploi == null) {
			if (other.ref_emploi != null)
				return false;
		} else if (!ref_emploi.equals(other.ref_emploi))
			return false;
		return true;
	}
	public Emploi(int id_emploi, String titre_emploi, String descriptif_emploi, String secteur, String ref_emploi,
			Date date_expiration) {
		
		this.id_emploi = id_emploi;
		this.titre_emploi = titre_emploi;
		this.descriptif_emploi = descriptif_emploi;
		this.secteur = secteur;
		this.ref_emploi = ref_emploi;
		this.date_expiration = date_expiration;
	}
	public Emploi(String titre_emploi, String descriptif_emploi, String secteur, String ref_emploi,
			Date date_expiration) {
		
		this.titre_emploi = titre_emploi;
		this.descriptif_emploi = descriptif_emploi;
		this.secteur = secteur;
		this.ref_emploi = ref_emploi;
		this.date_expiration = date_expiration;
	}
	public Emploi(int id_emploi, String ref_emploi, Date date_expiration) {
		super();
		this.id_emploi = id_emploi;
		this.ref_emploi = ref_emploi;
		this.date_expiration = date_expiration;
	}
	



}

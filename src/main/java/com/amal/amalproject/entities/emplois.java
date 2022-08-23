package com.amal.amalproject.entities;

import java.util.Date;
import java.util.Objects;

public class emplois {
    private int id_emploi;
    private String titre_emploi;
    private String descriptif_emploi;
    private String secteur;
    private String ref_emploi;
    private Date date_expiration;
    private int id_compte;

    public emplois() {
    }

    public emplois(int id_emploi, String titre_emploi, String descriptif_emploi, String secteur, String ref_emploi, Date date_expiration, int id_compte) {
        this.id_emploi = id_emploi;
        this.titre_emploi = titre_emploi;
        this.descriptif_emploi = descriptif_emploi;
        this.secteur = secteur;
        this.ref_emploi = ref_emploi;
        this.date_expiration = date_expiration;
        this.id_compte = id_compte;
    }

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

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof emplois)) return false;
        emplois emplois = (emplois) o;
        return getId_emploi() == emplois.getId_emploi() && getId_compte() == emplois.getId_compte() && Objects.equals(getRef_emploi(), emplois.getRef_emploi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_emploi(), getRef_emploi(), getId_compte());
    }

    @Override
    public String toString() {
        return "emplois{" +
                "id_emploi=" + id_emploi +
                ", titre_emploi='" + titre_emploi + '\'' +
                ", descriptif_emploi='" + descriptif_emploi + '\'' +
                ", secteur='" + secteur + '\'' +
                ", ref_emploi='" + ref_emploi + '\'' +
                ", date_expiration=" + date_expiration +
                ", id_compte=" + id_compte +
                '}';
    }
}

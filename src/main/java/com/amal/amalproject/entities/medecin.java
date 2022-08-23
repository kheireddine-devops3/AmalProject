package com.amal.amalproject.entities;

import java.util.Objects;

public class medecin extends User {

private String matricule;
private String specialite;
private int id_ordre;
private int cin;
private String Assurance;
private int id_user;
private String inscrit_ordre;

    public medecin() {
        super();
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getId_ordre() {
        return id_ordre;
    }

    public void setId_ordre(int id_ordre) {
        this.id_ordre = id_ordre;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getAssurance() {
        return Assurance;
    }

    public void setAssurance(String assurance) {
        Assurance = assurance;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getInscrit_ordre() {
        return inscrit_ordre;
    }

    public void setInscrit_ordre(String inscrit_ordre) {
        this.inscrit_ordre = inscrit_ordre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof medecin)) return false;
        if (!super.equals(o)) return false;
        medecin medecin = (medecin) o;
        return getId_ordre() == medecin.getId_ordre() && getId_user() == medecin.getId_user() && Objects.equals(getMatricule(), medecin.getMatricule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMatricule(), getId_ordre(), getId_user());
    }

    @Override
    public String toString() {
        return "medecin{" +
                "matricule='" + matricule + '\'' +
                ", specialite='" + specialite + '\'' +
                ", id_ordre=" + id_ordre +
                ", cin=" + cin +
                ", Assurance='" + Assurance + '\'' +
                ", id_user=" + id_user +
                ", inscrit_ordre='" + inscrit_ordre + '\'' +
                ", id_user=" + id_user +
                ", nom_user='" + nom_user + '\'' +
                ", prenom_user='" + prenom_user + '\'' +
                ", date_naissance_user=" + date_naissance_user +
                ", photo_user='" + photo_user + '\'' +
                ", email_user='" + email_user + '\'' +
                ", telephone_user=" + telephone_user +
                ", sexe_user='" + sexe_user + '\'' +
                ", adresse_user='" + adresse_user + '\'' +
                '}';
    }
}

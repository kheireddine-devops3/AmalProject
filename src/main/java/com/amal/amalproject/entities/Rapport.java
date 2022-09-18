package com.amal.amalproject.entities;

import java.util.Objects;

public class Rapport {
    
    private int id_rapport;
    private String nom;
    private String prenom;
    private String mail;
    private String numTel;
    private String sujet;
    private String description;

    public Rapport(int id_rapport, String nom, String prenom, String mail, String numTel, String sujet, String description) {
        this.id_rapport = id_rapport;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numTel = numTel;
        this.sujet = sujet;
        this.description = description;
    }

    public Rapport(String nom, String prenom, String mail, String numTel, String sujet, String description) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numTel = numTel;
        this.sujet = sujet;
        this.description = description;
    }

    public int getId_rapport() {
        return id_rapport;
    }

    public void setId_rapport(int id_rapport) {
        this.id_rapport = id_rapport;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rapport)) return false;
        Rapport rapport = (Rapport) o;
        return getId_rapport() == rapport.getId_rapport();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_rapport());
    }

    @Override
    public String toString() {
        return "Rapport{" +
                "id_rapport=" + id_rapport +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", numTel=" + numTel +
                ", sujet='" + sujet + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

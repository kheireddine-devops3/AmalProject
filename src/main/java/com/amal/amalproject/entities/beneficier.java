package com.amal.amalproject.entities;

import java.util.Date;
import java.util.Objects;

public class beneficier extends User{
    private int carte_handicap;
    private Date date_expiration;

    private String nom;
    private String prenom;
    private String carte_img;


    public beneficier(int id_user, String nom_user, String prenom_user, Date date_naissance_user, String photo_user, String email_user, int telephone_user, String sexe_user, String adresse_user, int carte_handicap, Date date_expiration, String nom, String prenom, String carte_img) {
        super(id_user, nom_user, prenom_user, date_naissance_user, photo_user, email_user, telephone_user, sexe_user, adresse_user);
        this.carte_handicap = carte_handicap;
        this.date_expiration = date_expiration;

        this.nom = nom;
        this.prenom = prenom;
        this.carte_img = carte_img;
    }

    public beneficier() {
        super();
    }

    public int getCarte_handicap() {
        return carte_handicap;
    }

    public void setCarte_handicap(int carte_handicap) {
        this.carte_handicap = carte_handicap;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
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

    public String getCarte_img() {
        return carte_img;
    }

    public void setCarte_img(String carte_img) {
        this.carte_img = carte_img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof beneficier)) return false;
        if (!super.equals(o)) return false;
        beneficier that = (beneficier) o;
        return getCarte_handicap() == that.getCarte_handicap();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCarte_handicap());
    }

    @Override
    public String toString() {
        return "beneficier{" +
                "carte_handicap=" + carte_handicap +
                ", date_expiration=" + date_expiration +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", carte_img='" + carte_img + '\'' +
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

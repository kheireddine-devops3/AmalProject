package com.amal.amalproject.entities;

import java.util.Objects;

public class admin {
    private int id_admin;
    private String nom;
    private String prenom;
    private String login;
    private String mot_de_passe;
    private String image_admin;

    public admin() {
    }

    public admin(int id_admin, String nom, String prenom, String login, String mot_de_passe, String image_admin) {
        this.id_admin = id_admin;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
        this.image_admin = image_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getImage_admin() {
        return image_admin;
    }

    public void setImage_admin(String image_admin) {
        this.image_admin = image_admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof admin)) return false;
        admin admin = (admin) o;
        return getId_admin() == admin.getId_admin() && Objects.equals(getLogin(), admin.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_admin(), getLogin());
    }

    @Override
    public String toString() {
        return "admin{" +
                "id_admin=" + id_admin +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", image_admin='" + image_admin + '\'' +
                '}';
    }


}

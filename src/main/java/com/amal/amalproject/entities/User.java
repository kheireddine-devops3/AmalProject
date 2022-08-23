package com.amal.amalproject.entities;


import java.util.Date;
import java.util.Objects;

public class User {
    protected int id_user;
    protected String nom_user;
    protected String prenom_user;
    protected Date date_naissance_user;
    protected String photo_user;
    protected String email_user;
    protected int telephone_user;
    protected String sexe_user;
    protected String adresse_user;

    public User() {
    }

    public User(int id_user, String nom_user, String prenom_user, Date date_naissance_user, String photo_user, String email_user, int telephone_user, String sexe_user, String adresse_user) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.date_naissance_user = date_naissance_user;
        this.photo_user = photo_user;
        this.email_user = email_user;
        this.telephone_user = telephone_user;
        this.sexe_user = sexe_user;
        this.adresse_user = adresse_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id_user == user.id_user && telephone_user == user.telephone_user && Objects.equals(email_user, user.email_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_user, email_user, telephone_user);
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
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

package com.amal.amalproject.entities;

import java.util.Date;
import java.util.Objects;

public class benevole extends User{

    private String profession;
    private int id_user;

    public benevole() {
        super();
    }

    public benevole(int id_user, String nom_user, String prenom_user, Date date_naissance_user, String photo_user, String email_user, int telephone_user, String sexe_user, String adresse_user, String profession, int id_user1) {
        super(id_user, nom_user, prenom_user, date_naissance_user, photo_user, email_user, telephone_user, sexe_user, adresse_user);
        this.profession = profession;
        this.id_user = id_user1;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof benevole)) return false;
        if (!super.equals(o)) return false;
        benevole benevole = (benevole) o;
        return getId_user() == benevole.getId_user();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId_user());
    }

    @Override
    public String toString() {
        return "benevole{" +
                "profession='" + profession + '\'' +
                ", id_user=" + id_user +
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

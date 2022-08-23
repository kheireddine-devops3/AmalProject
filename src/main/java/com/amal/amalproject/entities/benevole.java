package com.amal.amalproject.entities;

import java.util.Date;
import java.util.Objects;

public class benevole extends User{

    private String profession;


    public benevole() {
        super();
    }

    public benevole(int id_user, String nom_user, String prenom_user, Date date_naissance_user, String photo_user, String email_user, int telephone_user, String sexe_user, String adresse_user, String profession) {
        super(id_user, nom_user, prenom_user, date_naissance_user, photo_user, email_user, telephone_user, sexe_user, adresse_user);
        this.profession = profession;

    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }



    @Override
    public String toString() {
        return "benevole{" +
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

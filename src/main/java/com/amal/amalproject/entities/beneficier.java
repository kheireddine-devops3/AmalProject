package com.amal.amalproject.entities;

import java.util.Date;
import java.util.Objects;

public class beneficier extends User{
    private int carte_handicap;
    private Date date_expiration;
    private int id_user;
    private String nom;
    private String prenom;
    private String carte_img;


    public beneficier(int id_user, String nom_user, String prenom_user, Date date_naissance_user, String photo_user, String email_user, int telephone_user, String sexe_user, String adresse_user, int carte_handicap, Date date_expiration, int id_user1, String nom, String prenom, String carte_img) {
        super(id_user, nom_user, prenom_user, date_naissance_user, photo_user, email_user, telephone_user, sexe_user, adresse_user);
        this.carte_handicap = carte_handicap;
        this.date_expiration = date_expiration;
        this.id_user = id_user1;
        this.nom = nom;
        this.prenom = prenom;
        this.carte_img = carte_img;
    }

    public beneficier() {
        super();

    }


}

package com.amal.amalproject.entities;

import java.util.Objects;

public class organisation {

    private int matricule_fiscale;
    private  String nom_organisation;
    private String forme_juridique;
    private int num_tel;
    private String email;
    private String adresse;
    private int id_compte;

    public organisation() {
    }

    public organisation(int matricule_fiscale, String nom_organisation, String forme_juridique, int num_tel, String email, String adresse, int id_compte) {
        this.matricule_fiscale = matricule_fiscale;
        this.nom_organisation = nom_organisation;
        this.forme_juridique = forme_juridique;
        this.num_tel = num_tel;
        this.email = email;
        this.adresse = adresse;
        this.id_compte = id_compte;
    }

    public int getMatricule_fiscale() {
        return matricule_fiscale;
    }

    public void setMatricule_fiscale(int matricule_fiscale) {
        this.matricule_fiscale = matricule_fiscale;
    }

    public String getNom_organisation() {
        return nom_organisation;
    }

    public void setNom_organisation(String nom_organisation) {
        this.nom_organisation = nom_organisation;
    }

    public String getForme_juridique() {
        return forme_juridique;
    }

    public void setForme_juridique(String forme_juridique) {
        this.forme_juridique = forme_juridique;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
        if (!(o instanceof organisation)) return false;
        organisation that = (organisation) o;
        return getMatricule_fiscale() == that.getMatricule_fiscale() && getId_compte() == that.getId_compte() && Objects.equals(getNom_organisation(), that.getNom_organisation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricule_fiscale(), getNom_organisation(), getId_compte());
    }

    @Override
    public String toString() {
        return "organisation{" +
                "matricule_fiscale=" + matricule_fiscale +
                ", nom_organisation='" + nom_organisation + '\'' +
                ", forme_juridique='" + forme_juridique + '\'' +
                ", num_tel=" + num_tel +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", id_compte=" + id_compte +
                '}';
    }
}

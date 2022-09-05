package com.amal.amalproject.entities;

public class Medecin extends User {
    private String matricule;
    private String specialite;
    private String cin;
    private String assurance;


    /* Start Section Constructor */
    public Medecin() {
    }
    /* End Section Constructor */


    /* Start Section Getters & Setters */
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }
    /* End Section Getters & Setters */


    /* Start Section ToString */

    @Override
    public String toString() {
        return "Medecin{" +
                "matricule='" + matricule + '\'' +
                ", specialite='" + specialite + '\'' +
                ", cin='" + cin + '\'' +
                ", assurance='" + assurance + '\'' +
                ", user='" + super.toString()+ '\'' +
                '}';
    }
    /* End Section ToString */
}

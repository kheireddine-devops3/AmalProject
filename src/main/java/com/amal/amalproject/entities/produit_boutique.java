package com.amal.amalproject.entities;

import java.util.Objects;

public class produit_boutique {

    private int id_produit;
    private String libele;
    private double prix_produit;
    private String descriptiion_produit;
    private String photo_produit;
    private int id_benificier;

    public produit_boutique() {

    }

    public produit_boutique(int id_produit, String libele, double prix_produit, String descriptiion_produit, String photo_produit, int id_benificier) {
        this.id_produit = id_produit;
        this.libele = libele;
        this.prix_produit = prix_produit;
        this.descriptiion_produit = descriptiion_produit;
        this.photo_produit = photo_produit;
        this.id_benificier = id_benificier;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public double getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(double prix_produit) {
        this.prix_produit = prix_produit;
    }

    public String getDescriptiion_produit() {
        return descriptiion_produit;
    }

    public void setDescriptiion_produit(String descriptiion_produit) {
        this.descriptiion_produit = descriptiion_produit;
    }

    public String getPhoto_produit() {
        return photo_produit;
    }

    public void setPhoto_produit(String photo_produit) {
        this.photo_produit = photo_produit;
    }

    public int getId_benificier() {
        return id_benificier;
    }

    public void setId_benificier(int id_benificier) {
        this.id_benificier = id_benificier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof produit_boutique)) return false;
        produit_boutique that = (produit_boutique) o;
        return getId_produit() == that.getId_produit() && getId_benificier() == that.getId_benificier();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_produit(), getId_benificier());
    }

    @Override
    public String toString() {
        return "produit_boutique{" +
                "id_produit=" + id_produit +
                ", libele='" + libele + '\'' +
                ", prix_produit=" + prix_produit +
                ", descriptiion_produit='" + descriptiion_produit + '\'' +
                ", photo_produit='" + photo_produit + '\'' +
                ", id_benificier=" + id_benificier +
                '}';
    }
}

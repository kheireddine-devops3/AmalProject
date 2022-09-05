package com.amal.amalproject.entities;

import java.util.Objects;

public class dons {
    private static int id_dons;
    private static String libele_dons;
    private static String description_dons;
    private static String  photo_produit_dons;
    private static String type_dons;

    public dons() {
    }

    public dons(int id_dons, String libele_dons, String description_dons, String photo_produit_dons, String type_dons) {
        this.id_dons = id_dons;
        this.libele_dons = libele_dons;
        this.description_dons = description_dons;
        this.photo_produit_dons = photo_produit_dons;
        this.type_dons = type_dons;
    }

    public dons(String libele_dons, String description_dons, String photo_produit_dons, String type_dons) {
        
        this.libele_dons = libele_dons;
        this.description_dons = description_dons;
        this.photo_produit_dons = photo_produit_dons;
        this.type_dons = type_dons;
    }



    public int getId_dons() {
        return id_dons;
    }

    public void setId_dons(int id_dons) {
        this.id_dons = id_dons;
    }

    public static String getLibele_dons() {
        return libele_dons;
    }

    public void setLibele_dons(String libele_dons) {
        this.libele_dons = libele_dons;
    }

    public static String getDescription_dons() {
        return description_dons;
    }

    public void setDescription_dons(String description_dons) {
        this.description_dons = description_dons;
    }

    public static String getPhoto_produit_dons() {
        return photo_produit_dons;
    }

    public void setPhoto_produit_dons(String photo_produit_dons) {
        this.photo_produit_dons = photo_produit_dons;
    }

    public static String getType_dons() {
        return type_dons;
    }

    public void setType_dons(String type_dons) {
        this.type_dons = type_dons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof dons)) return false;
        dons dons = (dons) o;
        return getId_dons() == dons.getId_dons();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_dons());
    }

    @Override
    public String toString() {
        return "dons{" +
                "id_dons=" + id_dons +
                ", libele_dons='" + libele_dons + '\'' +
                ", description_dons='" + description_dons + '\'' +
                ", photo_produit_dons='" + photo_produit_dons + '\'' +
                ", type_dons='" + type_dons + '\'' +
                '}';
    }
}

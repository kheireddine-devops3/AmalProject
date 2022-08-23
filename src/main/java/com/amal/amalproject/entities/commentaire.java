package com.amal.amalproject.entities;

import java.util.Objects;

public class commentaire {
    private int id_commentaire;
    private String contenue;


    public commentaire() {
    }

    public commentaire(int id_commentaire, String contenue) {
        this.id_commentaire = id_commentaire;
        this.contenue = contenue;

    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof commentaire)) return false;
        commentaire that = (commentaire) o;
        return getId_commentaire() == that.getId_commentaire();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_commentaire());
    }

    @Override
    public String toString() {
        return "commentaire{" +
                "id_commentaire=" + id_commentaire +
                ", contenue='" + contenue + '\'' +
                '}';
    }
}

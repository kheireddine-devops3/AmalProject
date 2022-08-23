package com.amal.amalproject.entities;

import java.util.Date;
import java.util.Objects;

public class demandeaide {
    private int id_demande_aide;
    private String contenue;
    private Date date_publication;
    private String sujet;

    public demandeaide() {
    }

    public demandeaide(int id_demande_aide, String contenue, Date date_publication, String sujet) {
        this.id_demande_aide = id_demande_aide;
        this.contenue = contenue;
        this.date_publication = date_publication;
        this.sujet = sujet;
    }

    public int getId_demande_aide() {
        return id_demande_aide;
    }

    public void setId_demande_aide(int id_demande_aide) {
        this.id_demande_aide = id_demande_aide;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public Date getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof demandeaide)) return false;
        demandeaide that = (demandeaide) o;
        return getId_demande_aide() == that.getId_demande_aide();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_demande_aide());
    }

    @Override
    public String toString() {
        return "demandeaide{" +
                "id_demande_aide=" + id_demande_aide +
                ", contenue='" + contenue + '\'' +
                ", date_publication=" + date_publication +
                ", sujet='" + sujet + '\'' +
                '}';
    }
}

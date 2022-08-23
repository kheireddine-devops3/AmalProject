package com.amal.amalproject.entities;

import java.util.Date;
import java.util.Objects;

public class rendez_vous {

    private int id_rendez_vous;
    private Date date_rendez_vous;
    private int id_medecin;
    private int id_beneficier;

    public rendez_vous() {
    }

    public rendez_vous(int id_rendez_vous, Date date_rendez_vous, int id_medecin, int id_beneficier) {
        this.id_rendez_vous = id_rendez_vous;
        this.date_rendez_vous = date_rendez_vous;
        this.id_medecin = id_medecin;
        this.id_beneficier = id_beneficier;
    }

    public int getId_rendez_vous() {
        return id_rendez_vous;
    }

    public void setId_rendez_vous(int id_rendez_vous) {
        this.id_rendez_vous = id_rendez_vous;
    }

    public Date getDate_rendez_vous() {
        return date_rendez_vous;
    }

    public void setDate_rendez_vous(Date date_rendez_vous) {
        this.date_rendez_vous = date_rendez_vous;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public int getId_beneficier() {
        return id_beneficier;
    }

    public void setId_beneficier(int id_beneficier) {
        this.id_beneficier = id_beneficier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof rendez_vous)) return false;
        rendez_vous that = (rendez_vous) o;
        return getId_rendez_vous() == that.getId_rendez_vous() && getId_medecin() == that.getId_medecin() && getId_beneficier() == that.getId_beneficier();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_rendez_vous(), getId_medecin(), getId_beneficier());
    }

    @Override
    public String toString() {
        return "rendez_vous{" +
                "id_rendez_vous=" + id_rendez_vous +
                ", date_rendez_vous=" + date_rendez_vous +
                ", id_medecin=" + id_medecin +
                ", id_beneficier=" + id_beneficier +
                '}';
    }
}

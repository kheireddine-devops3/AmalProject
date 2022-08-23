package com.amal.amalproject.entities;

import java.util.Objects;

public class video {

    private int id_video;
    private String nom;
    private String url;
    private int id_formation;

    public video() {
    }

    public video(int id_video, String nom, String url, int id_formation) {
        this.id_video = id_video;
        this.nom = nom;
        this.url = url;
        this.id_formation = id_formation;
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof video)) return false;
        video video = (video) o;
        return getId_video() == video.getId_video() && getId_formation() == video.getId_formation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_video(), getId_formation());
    }

    @Override
    public String toString() {
        return "video{" +
                "id_video=" + id_video +
                ", nom='" + nom + '\'' +
                ", url='" + url + '\'' +
                ", id_formation=" + id_formation +
                '}';
    }
}

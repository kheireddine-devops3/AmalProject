package com.amal.amalproject.entities;

import java.util.Objects;

public class video {

    private int id_video;
    private String nom;
    private String url;

    public video() {
    }

    public video(int id_video, String nom, String url) {
        this.id_video = id_video;
        this.nom = nom;
        this.url = url;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof video)) return false;
        video video = (video) o;
        return getId_video() == video.getId_video();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_video());
    }
//a
    @Override
    public String toString() {
        return "video{" +
                "id_video=" + id_video +
                ", nom='" + nom + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

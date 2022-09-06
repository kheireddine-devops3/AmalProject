package com.amal.amalproject.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Video extends Formation {
	    private int id_video;
	    private String nom;
	    private String url;
		private int id_formation;
		
		public Video() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Video(int id_video, String nom, String url) {
			super();
			this.id_video = id_video;
			this.nom = nom;
			this.url = url;
		
		}
		
		
		public Video(int id_video, String nom, String url, int id_formation) {
			super();
			this.id_video = id_video;
			this.nom = nom;
			this.url = url;
			this.id_formation = id_formation;
		}
		
		public Video(int id_formation, String theme, String descriptif, LocalDate date_publication) {
			super(id_formation, theme, descriptif, date_publication);
			// TODO Auto-generated constructor stub
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
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + Objects.hash(id_formation, id_video, nom, url);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Video other = (Video) obj;
			return id_formation == other.id_formation && id_video == other.id_video && Objects.equals(nom, other.nom)
					&& Objects.equals(url, other.url);
		}
		@Override
		public String toString() {
			return "Video [id_video=" + id_video + ", nom=" + nom + ", url=" + url + ", id_formation=" + id_formation
					+ ", getId_video()=" + getId_video() + ", getNom()=" + getNom() + ", getUrl()=" + getUrl()
					+ ", getId_formation()=" + getId_formation() + "]";
		}
		
		
	  


}

package com.youssef.Miniprojet.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;
	private String Modele;
	private Date RelaseDate;
	private Double prix;
	private String Coleur;
	public Voiture() {
		super();
	}
	public Voiture( String modele, Date relaseDate, Double prix, String coleur) {
		super();
		
		Modele = modele;
		RelaseDate = relaseDate;
		this.prix = prix;
		Coleur = coleur;
	}
	public Long getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	public String getModele() {
		return Modele;
	}
	public void setModele(String modele) {
		Modele = modele;
	}
	public Date getRelaseDate() {
		return RelaseDate;
	}
	public void setRelaseDate(Date relaseDate) {
		RelaseDate = relaseDate;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getColeur() {
		return Coleur;
	}
	public void setColeur(String coleur) {
		Coleur = coleur;
	}
	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", Modele=" + Modele + ", RelaseDate=" + RelaseDate + ", prix="
				+ prix + ", Coleur=" + Coleur + "]";
	}
	

}

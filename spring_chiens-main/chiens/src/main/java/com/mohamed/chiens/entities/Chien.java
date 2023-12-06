package com.mohamed.chiens.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Chien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private long idChien;
private String nomChien;
private double prixChien;
private Date datenaissance;
@ManyToOne
private Race race;
/*@OneToOne
private Image image;*/
@OneToMany (mappedBy = "chien")
private List<Image> images;

//private String imagePath;


public Chien() {
	super();
	// TODO Auto-generated constructor stub
}

public Race getRace() {
	return race;
}

public void setRace(Race race) {
	this.race = race;
}


public Chien(String nomChien, double prixChien, Date datenaissance) {
	super();
	this.nomChien = nomChien;
	this.prixChien = prixChien;
	this.datenaissance = datenaissance;
}



public long getIdChien() {
	return idChien;
}
public void setIdChien(long idChien) {
	this.idChien = idChien;
}
public String getNomChien() {
	return nomChien;
}
public void setNomChien(String nomChien) {
	this.nomChien = nomChien;
}
public double getPrixChien() {
	return prixChien;
}
public void setPrixChien(double prixChien) {
	this.prixChien = prixChien;
}
public Date getDatenaissance() {
	return datenaissance;
}
public void setDatenaissance(Date datenaissance) {
	this.datenaissance = datenaissance;
}

@Override
public String toString() {
	return "Chien [idChien=" + idChien + ", nomChien=" + nomChien + ", prixChien=" + prixChien + ", datenaissance="
			+ datenaissance + "]";
}




public List<Image> getImages() {
	return images;
}

public void setImages(List<Image> images) {
	this.images = images;
}





}

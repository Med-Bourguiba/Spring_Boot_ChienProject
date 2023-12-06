package com.mohamed.chiens.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Race {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRc;
	private String nomRc;
	private String descriptionRc;
	
	@OneToMany (mappedBy ="race")
	@JsonIgnore 
	private List<Chien> chiens;
	
	
	public List<Chien> getChiens() {
		return chiens;
	}
	public void setChiens(List<Chien> chiens) {
		this.chiens = chiens;
	}
	
//	public Race () {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	public Long getIdRc() {
		return idRc;
	}
	public void setIdRc(Long idRc) {
		this.idRc = idRc;
	}
	public String getNomRc() {
		return nomRc;
	}
	public void setNomRc(String nomRc) {
		this.nomRc= nomRc;
	}
	public String getDescriptionRc() {
		return descriptionRc;
	}
	public void setDescriptionRc(String descriptionRc) {
		this.descriptionRc = descriptionRc;
	}	
}

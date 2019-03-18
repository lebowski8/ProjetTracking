package com.trackingapp.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {
	
	@Id @GeneratedValue
	private Long idUtilisateur;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private Double poids;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "utilisateur")
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE) 
	private Collection<Activity> activities ;
	
	
	public Utilisateur(String nom, String prenom, Double poids, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.poids = poids;
		this.username = username;
		this.password = password;
	}

	public Utilisateur() {
		super();
	}

	

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

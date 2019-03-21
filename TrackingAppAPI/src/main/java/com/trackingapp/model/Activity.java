package com.trackingapp.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Activity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idactivity;
	private String typeSport;
	private double distance;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateFin;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateDebut;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "activity")
	private Collection<CoordonneesGPS> coordonnees;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUtilisateur")
	@JsonBackReference
	private Utilisateur utilisateur;

	public Long getId() {
		return idactivity;
	}

	public void setId(Long id) {
		this.idactivity = id;
	}

	public String getTypeSport() {
		return typeSport;
	}

	public void setTypeSport(String typeSport) {
		this.typeSport = typeSport;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public Calendar getDateFin() {
		return dateFin;
	}

	public void setDateFin(Calendar dateFin) {
		this.dateFin = dateFin;
	}

	public Calendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Calendar dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Collection<CoordonneesGPS> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Collection<CoordonneesGPS> coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Utilisateur getUtiliSateur() {
		return utilisateur;
	}

	public void setUtiliSateur(Utilisateur utiliSateur) {
		this.utilisateur = utiliSateur;
	}

	public Activity(String typeSport, double i, @NotNull Calendar dateFin, @NotNull Calendar dateDebut,
			 Utilisateur utiliSateur) {
		super();
		this.typeSport = typeSport;
		this.distance = i;
		this.dateFin = dateFin;
		this.dateDebut = dateDebut;
		this.utilisateur = utiliSateur;
	}

	public Activity() {
		super();
	}
	
	

}

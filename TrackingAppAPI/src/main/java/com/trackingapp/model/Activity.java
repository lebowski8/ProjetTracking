package com.trackingapp.model;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
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

public class Activity {
	@Id
	@GeneratedValue
	private Long id;
	private String typeSport;
	private Long distance;

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
	private Utilisateur utiliSateur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeSport() {
		return typeSport;
	}

	public void setTypeSport(String typeSport) {
		this.typeSport = typeSport;
	}

	public Long getDistance() {
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
		return utiliSateur;
	}

	public void setUtiliSateur(Utilisateur utiliSateur) {
		this.utiliSateur = utiliSateur;
	}

	public Activity(String typeSport, Long distance, @NotNull Calendar dateFin, @NotNull Calendar dateDebut,
			Collection<CoordonneesGPS> coordonnees, Utilisateur utiliSateur) {
		super();
		this.typeSport = typeSport;
		this.distance = distance;
		this.dateFin = dateFin;
		this.dateDebut = dateDebut;
		this.coordonnees = coordonnees;
		this.utiliSateur = utiliSateur;
	}

	public Activity() {
		super();
	}
	
	

}

package com.trackingapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CoordonneesGPS {
	
	@Id @GeneratedValue
	private Long idCoordonneesGPS;
	
	@Column
	private Double lng;
	
	@Column
	private Double lat;
	
	@Column
	private Date date;
	
	
	
	
	public CoordonneesGPS() {
		super();
	}

	public CoordonneesGPS(Double lng, Double lat, Date date) {
		super();
		this.lng = lng;
		this.lat = lat;
		this.date = date;
	}

	public Long getIdCoordonneesGPS() {
		return idCoordonneesGPS;
	}

	public void setIdCoordonneesGPS(Long idCoordonneesGPS) {
		this.idCoordonneesGPS = idCoordonneesGPS;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}

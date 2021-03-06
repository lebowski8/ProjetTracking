package com.trackingapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CoordonneesGPS implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id @GeneratedValue
	private Long idCoordonneesGPS;
	

	@Column
	private Double lng;
	
	@Column
	private Double lat;
	
	@Column
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idactivity")
    @JsonBackReference
	private Activity activity;
	
	
	
	public CoordonneesGPS() {
		super();
	}

	public CoordonneesGPS(Double lng, Double lat, Date date, Activity activity) {
		super();
		this.lng = lng;
		this.lat = lat;
		this.date = date;
		this.activity = activity;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
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

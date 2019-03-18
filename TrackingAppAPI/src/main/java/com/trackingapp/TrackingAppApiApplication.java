package com.trackingapp;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.trackingapp.dao.ActivityRepository;
import com.trackingapp.dao.UtilisateurRepository;
import com.trackingapp.model.Activity;
import com.trackingapp.model.CoordonneesGPS;
import com.trackingapp.model.Utilisateur;

@SpringBootApplication
public class TrackingAppApiApplication implements CommandLineRunner{

	@Autowired
	private  ActivityRepository activity;
	@Autowired
	private  UtilisateurRepository util;
	public static void main(String[] args) {
		SpringApplication.run(TrackingAppApiApplication.class, args);
	
		 
	}
	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		Utilisateur moi = new Utilisateur("junior","lebowski",12.5, "khyar", "minou minou");
		util.save(moi);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
		Calendar dateFin = new GregorianCalendar(2019,4,31);
		Calendar dateDebut = new GregorianCalendar(2019,3,31);
		
		Activity myactivity = new Activity("foot",15, dateFin, dateDebut, moi);
		activity.save(myactivity)	;
		activity.toString();
	}

}

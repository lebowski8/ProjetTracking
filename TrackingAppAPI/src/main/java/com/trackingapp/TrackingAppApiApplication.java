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
		Utilisateur user2 = new Utilisateur("mohamed","bahammou",12.5, "pseudo", "password");
		Utilisateur user3 = new Utilisateur("ayoub","lebowski",12.5, "lebowski", "password");
		Utilisateur user4 = new Utilisateur("ayoub","lebowski",12.5, "lebowski", "password");
		
		
		util.save(moi);
		util.save(user2);
		util.save(user3);
		util.save(user4);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
		Calendar dateFin = new GregorianCalendar(2019,4,31);
		Calendar dateDebut = new GregorianCalendar(2019,3,31);
		
		Activity myactivity = new Activity("foot",15, dateFin, dateDebut, moi);
		Activity activityU2 = new Activity("foot",15, dateFin, dateDebut, user2);
		Activity activityU3 = new Activity("foot",15, dateFin, dateDebut, user3);
		Activity activityU4 = new Activity("foot",15, dateFin, dateDebut, user4);
		activity.save(myactivity)	;
		activity.save(activityU2)	;
		activity.save(activityU3)	;
		activity.save(activityU4)	;
		System.out.println("SERVER LAUNCHED...");
	}

}

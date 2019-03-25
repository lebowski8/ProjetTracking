package com.trackingapp.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trackingapp.model.Activity;
import com.trackingapp.model.Utilisateur;



public interface ActivityRepository extends JpaRepository<Activity, Long>{
	
	@Query("select a from Activity a where a.utilisateur.idUtilisateur = :id AND a.typeSport = :typeSport")
	public Collection<Activity> findUserActivitiesBySport(@Param("id") Long user, @Param("typeSport") String typeSport);
	
}

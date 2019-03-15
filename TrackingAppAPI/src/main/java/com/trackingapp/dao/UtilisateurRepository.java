package com.trackingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trackingapp.model.Utilisateur;




public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	public Utilisateur findByUsername(String username);

}

package com.trackingapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trackingapp.dao.UtilisateurRepository;
import com.trackingapp.exceptions.ResourceNotFoundException;
import com.trackingapp.model.Utilisateur;



@RestController
@CrossOrigin("*")
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
    public Utilisateur getUtilisateur(@PathVariable Long id) {
		Utilisateur user = new Utilisateur();
		user = utilisateurRepository.findById(id).orElse(null);
		user.setPassword("");
        return user;
    }
			
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public Utilisateur createUser( Utilisateur user) throws Exception{
		Utilisateur usertmp = utilisateurRepository.findByUsername(user.getUsername());
		if(usertmp!=null)
			throw new Exception("Pseudo existe déja");
		return utilisateurRepository.save(user);
    }

	@RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		return utilisateurRepository.findById(id).map(user -> {
			utilisateurRepository.delete(user);
	        return ResponseEntity.ok().build();
	    }).orElseThrow(() -> new ResourceNotFoundException("UserID " + id + " not found"));

    }
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
    public Utilisateur updateUser(@PathVariable Long id,@RequestBody Utilisateur userRequest) {
		return utilisateurRepository.findById(id).map(user -> {
			user.setNom(userRequest.getNom());
			user.setPrenom(userRequest.getPrenom());
			user.setUsername(userRequest.getUsername());
			user.setPassword(userRequest.getPassword());
			user.setPoids(userRequest.getPoids());
	        return utilisateurRepository.save(user);
	    }).orElseThrow(() -> new ResourceNotFoundException("UserID " + id + " not found"));

    }
	
}

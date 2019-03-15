package com.trackingapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trackingapp.dao.UtilisateurRepository;
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
	
	public Utilisateur createUser( Utilisateur user) throws Exception{
		Utilisateur usertmp = utilisateurRepository.findByUsername(user.getUsername());
		if(usertmp!=null)
			throw new Exception("Pseudo existe déja");
		
		return utilisateurRepository.save(user);
    }

	/*@RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		return userRepository.findById(id).map(user -> {
			userRepository.delete(user);
	        return ResponseEntity.ok().build();
	    }).orElseThrow(() -> new ResourceNotFoundException("UserID " + id + " not found"));

    }
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
    public User updateUser(@PathVariable Long id,@RequestBody User userRequest) {
		return userRepository.findById(id).map(user -> {
			user.setNom(userRequest.getNom());
			user.setPrenom(userRequest.getPrenom());
			user.setPseudo(userRequest.getPseudo());
			String hashPW=bCryptPasswordEncoder.encode(userRequest.getPassword());
			user.setPassword(hashPW);
			user.setEmail(userRequest.getEmail());
			user.setStatus(userRequest.getStatus());
			user.setValidated(false);
	        return userRepository.save(user);
	    }).orElseThrow(() -> new ResourceNotFoundException("UserID " + id + " not found"));

    }*/
	
}

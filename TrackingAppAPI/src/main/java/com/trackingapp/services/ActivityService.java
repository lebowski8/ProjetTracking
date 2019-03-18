package com.trackingapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trackingapp.dao.ActivityRepository;
import com.trackingapp.model.Activity;

@RestController
@CrossOrigin("*")
public class ActivityService {
	@Autowired
	private ActivityRepository activityR;
	
	@RequestMapping(value="/activities", method=RequestMethod.GET)
	public List<Activity> getCOntacts(){
		return activityR.findAll();
	}
	
	@RequestMapping(value="/activities/{id}", method=RequestMethod.GET)
	public Activity getActivity(@PathVariable Long id){
		return activityR.findById(id).orElse(null);
	}
	@RequestMapping(value="/activities", method=RequestMethod.POST)
	public Activity save(@RequestBody Activity c){
		return activityR.save(c);
	}
	@RequestMapping(value="/activities/{id}", method=RequestMethod.DELETE)
	public boolean deleteActivity(@RequestBody Long id){
		activityR.deleteById(id);
		return true;
	}
	@RequestMapping(value="/activities/{id}", method=RequestMethod.PUT)
	public Activity updateActivity(@PathVariable Long id , @RequestBody Activity c){
		c.setId(id);
		return activityR.save(c);
	}
}
	
	
	
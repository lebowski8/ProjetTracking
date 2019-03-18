package com.trackingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trackingapp.model.Activity;


public interface ActivityRepository extends JpaRepository<Activity, Long>{

}

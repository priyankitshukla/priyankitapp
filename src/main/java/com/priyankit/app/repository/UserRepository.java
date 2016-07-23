package com.priyankit.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.priyankit.app.model.User;

public interface UserRepository extends CrudRepository< User, String>{
	  
	  public User findByUsername(String username); 
	}

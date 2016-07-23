
package com.priyankit.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.priyankit.app.model.User;
@Repository
public interface UserRepository extends CrudRepository< User, String>{
	  
	  public User findByUsername(String username); 
	}

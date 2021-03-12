package com.au.mongodb.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.mongodb.model.User;

@Repository
public interface UserRepository extends MongoRepository <User,String> 
{
	
	 	User findUserById(String id);
	 	User findByUsername(String username);
	  	
}

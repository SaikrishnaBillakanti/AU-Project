package com.au.mongodb.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.mongodb.model.User;

@Repository
public interface CustomerRepository extends MongoRepository <User,Integer> 
{
	
	 	
}

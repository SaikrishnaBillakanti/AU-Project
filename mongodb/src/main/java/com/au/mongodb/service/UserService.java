package com.au.mongodb.service;


import java.util.List;

import com.au.mongodb.model.Transaction;
import com.au.mongodb.model.User;


public interface UserService
{

	public User getbyid(String id);
	public String createuser(User d);
 	public List<User> getAllDetails();
 	public Long getCount();
 	public User findUserByUsername(String username);
	public List<Transaction> getlist(String username);
    
}

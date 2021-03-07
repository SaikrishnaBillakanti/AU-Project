package com.au.mongodb.service;


import java.util.List;
import com.au.mongodb.model.User;


public interface UserService
{

	public User getbyid(String id);
	public String CreateUser(User d);
 	public List<User> getAllDetails();
 	public Long getCount();
 	public User findUserByUsername(String username);
    
}

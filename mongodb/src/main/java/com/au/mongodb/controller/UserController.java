package com.au.mongodb.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.au.mongodb.model.User;
import com.au.mongodb.service.UserService;
import java.util.List;


@RestController
@RequestMapping(value="/User")
public class UserController
{
	
   @Autowired
  UserService userservice;
		
	@PostMapping(value="/create")
	public User createUser(@RequestBody User a)
	{
		return userservice.CreateUser(a);
	}
	@GetMapping(value = "/all")
	public List<User> getAllDetails() {
		return userservice.getAllDetails();
	}
	@GetMapping(value="/{id}")
	public User getbyid(@PathVariable("id") String id)
	{
		return userservice.getbyid(id);	
	}
	
}
	
	
	
package com.au.mongodb.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.au.mongodb.Repository.CustomerRepository;
import com.au.mongodb.model.User;
import com.au.mongodb.service.CustomerService;

import java.util.List;


@RestController
@RequestMapping(value="/Customer")
public class CustomerController
{
	
   @Autowired
   CustomerService userservice;
		
	@PostMapping(value="/create")
	public String createCustomer(@RequestBody User a)
	{
		return userservice.CreateUser(a);
	}
	@GetMapping(value = "/all")
	public List<User> getAllDetails() {
		return userservice.getAllDetails();
	}
	
	
}
	
	
	
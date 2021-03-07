package com.au.mongodb.controller;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.mongodb.model.Transaction;
import com.au.mongodb.model.User;
import com.au.mongodb.service.TransactionService;
import com.au.mongodb.service.UserService;
import java.util.List;


@RestController
@RequestMapping(value="/User")
public class UserController
{
	
   @Autowired
   UserService userservice;
   @Autowired
   TransactionService transactionservice;
	

   @GetMapping(value="/verify")
   public User verifyuser(@RequestBody User a)
   {
	   User localUser = userservice.findUserByUsername(a.getUsername());

       if (localUser != null)
       {
           return localUser;
       }
      return null;
   }
	@PutMapping(value="/create")
	public String createUser(@RequestBody User a)
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
	@GetMapping(value = "/transaction")
    public List<Transaction> getTransactionList(@RequestParam("username") String username) {
        return transactionservice.findTransactionList(username);
    }
	//@PutMapping(value="/")
}
	
	
	
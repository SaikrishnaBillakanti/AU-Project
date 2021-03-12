package com.au.mongodb.controller;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.mongodb.model.Transaction;
import com.au.mongodb.model.User;
import com.au.mongodb.service.BaseAccountService;
import com.au.mongodb.service.TransactionService;
import com.au.mongodb.service.UserService;
import java.util.List;


@RestController
@RequestMapping(value="/api/User")
public class UserController
{
	
   @Autowired
   UserService userservice;
   @Autowired
   TransactionService transactionservice;
   @Autowired
   BaseAccountService baseaccountservice;
	
   
   @GetMapping(value="/verify")
   public String verifyuser(@RequestParam("username") String username)
   {
	   User localUser = userservice.findUserByUsername(username);

       if (localUser != null)
       {
           return "User exists change username";
       }
      return "proceed with creating account";
   }
   
	@PutMapping(value="/create")
	public String createUser(@RequestBody User a)
	{
		return userservice.createuser(a);
	} 
	@GetMapping(value = "/all")
	public List<User> getAllDetails() {
		return userservice.getAllDetails();
	}
	@PostMapping(value = "/deposit")
    public String deposit(@RequestParam("username") String username,@RequestParam("amount") double amount)
	{
       return baseaccountservice.deposit(amount, username);
        
    }
	
	@PostMapping(value = "/accountdeposit")
	public String accountdeposit(@RequestParam("Senderusername") String username,@RequestParam("recipientname") String recipient,@RequestParam("description") String description,@RequestParam("amount") double amount)
	{
	 return baseaccountservice.accountdeposit(amount, username, recipient, description);
	}
	@PostMapping(value="/withdraw")
	 public String withdraw(@RequestParam("username") String username,@RequestParam("amount") double amount)
	 {
		 baseaccountservice.withdraw(amount, username);
		 return "withdraw success";
	 }
	 @GetMapping(value="/getlist")
	 public List<Transaction> translist(@RequestParam("username") String username)
	 {
		 return userservice.getlist(username);
	 }
	 @GetMapping(value="/{id}")
	public User getbyid(@PathVariable("id") String id)
	{
		 return userservice.getbyid(id);	
	}

}
	

	
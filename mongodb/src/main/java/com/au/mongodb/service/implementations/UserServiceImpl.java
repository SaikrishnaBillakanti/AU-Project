package com.au.mongodb.service.implementations;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.mongodb.model.Transaction;
import com.au.mongodb.model.User;
import com.au.mongodb.repository.UserRepository;
import com.au.mongodb.service.BaseAccountService;
import com.au.mongodb.service.UserService;


@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userrepository;
	@Autowired
    private BaseAccountService baseaccountService;

	public List<User> getAllDetails()
	{
		return userrepository.findAll();
	}


	public String createuser(User user)
	{
        User localUser = userrepository.findByUsername(user.getUsername());

        if (localUser != null)
        {
             return "UserAlready Exists";
        }
        else
        {
        	user.setBankaccount(baseaccountService.createBankAccount());
            userrepository.insert(user);
        }
        
        return "User Created with Username "+user.getUsername()+"with accountnumber "+user.getBankaccount().getAccountNumber();
    }
	public Long getCount()
	{
		return userrepository.count();
	}
	public User findUserByUsername(String username) {
        return userrepository.findByUsername(username);
    }

	public User getbyid(String id) 
	{
		return userrepository.findUserById(id);
		
	}
	public List<Transaction> getlist(String username)
	{
		User c=userrepository.findByUsername(username);
		return c.getBankaccount().getTransactionList();
	}


}
	
	




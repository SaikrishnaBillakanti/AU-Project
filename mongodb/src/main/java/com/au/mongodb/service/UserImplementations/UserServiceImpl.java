package com.au.mongodb.service.UserImplementations;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.mongodb.Repository.UserRepository;
import com.au.mongodb.model.User;
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


	public String CreateUser(User user)
	{
        User localUser = userrepository.findByUsername(user.getUsername());

        if (localUser != null)
        {
             return "UserAlready Exists";
        }
        else
        {
        	user.setBA(baseaccountService.createBankAccount());
            userrepository.save(user);
        }

        return "User Created with Username "+user.getUsername()+"with accountnumber "+user.getBA().getAccountNumber();
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
		User c=userrepository.findUserById(id);
		return c;
	}
	
	


}

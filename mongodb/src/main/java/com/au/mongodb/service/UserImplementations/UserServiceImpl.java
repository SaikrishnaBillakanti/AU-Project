package com.au.mongodb.service.UserImplementations;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.mongodb.Repository.UserRepository;
import com.au.mongodb.model.User;
import com.au.mongodb.service.UserService;


@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userrepository;

	public List<User> getAllDetails()
	{
		return userrepository.findAll();
	}

	/*public String CreateUser(User d) {

		User newd = userrepository.save(d);
		return "User Created With Name " + newd.getFname();
	}*/
	public User CreateUser(User user)
	{
        User localUser = userrepository.findByUsername(user.getUsername());

        if (localUser != null)
        {
             System.out.println("UserAlready Exists");
             return null;
        	
        }
        else
        {
            localUser = userrepository.save(user);
        }

        return localUser;
    }
	public User findUserByUsername(String username) {
        return userrepository.findByUsername(username);
    }

   	public Long getCount() {
		return userrepository.count();
	}

	public User getbyid(String id) 
	{
		User c=userrepository.findUserById(id);
		return c;
	}
	


}

package com.au.mongodb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.*;
import com.au.mongodb.Repository.CustomerRepository;
import com.au.mongodb.model.User;

@Service
public class CustomerService
{
	@Autowired
	CustomerRepository customerrepository;
	
	public List<User> getAllDetails() {
		return customerrepository.findAll();
	}

	public String CreateUser(User d) {

		User newd = customerrepository.insert(d);
		return "User Created With Name " + newd.getFname();
	}

	public Long getCount() {
		return customerrepository.count();
	}

	public List<User> getAllByExample(User user) {
		Example<User> e = Example.of(user);
		return customerrepository.findAll(e);
	
	}
	
	
}

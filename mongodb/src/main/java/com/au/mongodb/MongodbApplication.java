package com.au.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.au.mongodb.Repository.UserRepository;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner
{
    @Autowired
    UserRepository customerRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

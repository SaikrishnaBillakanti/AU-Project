package com.au.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Recipients")
public class Recipient
{
	 @Id
	 private Long id;
	 private String name;
	 private String email;
	 private String phone;
	 private String accountNumber;
	 private String description; 
	 private User user;
	 
	 
	 
	 public Recipient() {
		super();		
	}
	public Recipient(String name, String email, String phone, String accountNumber, String description, User user) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.accountNumber = accountNumber;
		this.description = description;
		this.user = user;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser (User user) 
	{
		this.user = user;

	}
	
}
	 
	 



package com.au.mongodb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User 
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable=false,updatable=false)
	private String id;
	private String username;
    private String password;
	private String fname;
	private String lname;
	
	@Column(name="email",nullable=false,unique=true)
    private String email;
    private String phone;

    @OneToOne
    private BaseAccount BA;
    
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Recipient> RecipientList;


	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public BaseAccount getBA() {
		return BA;
	}

	public void setBA(BaseAccount bA) {
		BA = bA;
	}

	public List<Recipient> getRecipientList() {
		return RecipientList;
	}

	public void setRecipientList(List<Recipient> recipientList) {
		RecipientList = recipientList;
	}

	
	
	
	
	/*@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}*/
}

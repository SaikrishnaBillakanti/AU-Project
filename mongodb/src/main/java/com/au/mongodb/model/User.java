package com.au.mongodb.model;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User 
{
	@Id
	private String id;
	private String username;
    private String password;
	private String name;
    private String email;
    private String phone;
    private BaseAccount BA;
    private List<Recipient> RecipientList;


	public User() {
		super();
		
	}

	public User(String username, String password,String name, String email, String phone,
			BaseAccount bA, List<Recipient> recipientList) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		BA = bA;
		RecipientList = recipientList;
	}

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

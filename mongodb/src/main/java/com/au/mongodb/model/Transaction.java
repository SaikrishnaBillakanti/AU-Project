package com.au.mongodb.model;
import java.math.BigDecimal;
import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Transaction")
public class Transaction
{

	@Id
	private String id;
	private Date date;
	private String description;
	private String type;
    private String status;
    private double amount;
    private BigDecimal availableBalance;    

    public Transaction() {
    	
    }
	public Transaction(Date date, String description,String type,String status,double amount,
			BigDecimal availableBalance) {
		super();
		this.date = date;
		this.description = description;
		this.type=type;
		this.status = status;
		this.amount = amount;
		this.availableBalance = availableBalance;
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}
	
    
    
    
	
}

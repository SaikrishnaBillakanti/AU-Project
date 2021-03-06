package com.au.mongodb.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Transaction")
public class Transaction
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Date date;
	private String description;
    private String type;
    private String status;
    private double amount;
    private BigDecimal availableBalance;
    
    @ManyToOne
    @JoinColumn(name="base_account_id")
    private BaseAccount baseAccount;

    public Transaction() {
    	
    }
	public Transaction(long id, Date date, String description, String type, String status, double amount,
			BigDecimal availableBalance, BaseAccount baseAccount) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.type = type;
		this.status = status;
		this.amount = amount;
		this.availableBalance = availableBalance;
		this.baseAccount = baseAccount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public BaseAccount getBaseAccount() {
		return baseAccount;
	}
	public void setBaseAccount(BaseAccount baseAccount) {
		this.baseAccount = baseAccount;
	}
    
    
    
	
}
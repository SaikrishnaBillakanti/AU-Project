package com.au.mongodb.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Document(collection="BaseAccount")
public class BaseAccount
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private int accountNumber;
    private BigDecimal accountBalance;

    @OneToMany(mappedBy = "BaseAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaction> TransactionList;

    
	public BaseAccount(String id, int accountNumber, BigDecimal accountBalance,
			List<Transaction> TransactionList) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.TransactionList = TransactionList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<Transaction> getSavingsTransactionList() {
		return TransactionList;
	}

	public void setTransactionList(List<Transaction> TransactionList) {
		this.TransactionList = TransactionList;
	}

    
	}

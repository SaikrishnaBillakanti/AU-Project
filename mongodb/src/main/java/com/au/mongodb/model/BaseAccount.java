package com.au.mongodb.model;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="BaseAccount")
public class BaseAccount
{
	@Id
    private String id;
    private int accountNumber;
    private BigDecimal accountBalance;
    private List<Transaction> transactionList;
    public BaseAccount() {
    	
    }   
	public BaseAccount(int accountNumber, BigDecimal accountBalance,
			List<Transaction> transactionList) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.transactionList = transactionList;
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

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

    
	}

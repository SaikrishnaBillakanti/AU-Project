package com.au.mongodb.service;

import java.util.List;

import com.au.mongodb.model.Transaction;

public interface TransactionService
{
	List<Transaction> findTransactionList(String username);

    

    void saveDepositTransaction(Transaction primaryTransaction);

    
    void saveWithdrawTransaction(Transaction Transaction);

    
  
}

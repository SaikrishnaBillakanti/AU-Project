package com.au.mongodb.service;

import com.au.mongodb.model.Transaction;

public interface TransactionService
{
    void saveDepositTransaction(Transaction transaction);
    void saveWithdrawTransaction(Transaction transaction);  
}

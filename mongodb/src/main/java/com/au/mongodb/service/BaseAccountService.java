package com.au.mongodb.service;

import com.au.mongodb.model.BaseAccount;

public interface BaseAccountService
{
     BaseAccount getbyAccountnumber(int accountNumber);
     BaseAccount createBankAccount();
     String deposit(double amount, String username);
     void withdraw(double amount, String username);
     public String accountdeposit(double amount,String senderusername,String recipient,String description);
}

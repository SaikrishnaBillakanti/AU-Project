package com.au.mongodb.service;

import com.au.mongodb.model.BaseAccount;

public interface BaseAccountService
{
     BaseAccount getbyAccountnumber(int accountNumber);
     BaseAccount createBankAccount();
     void deposit(double amount, String username);
     void withdraw(double amount, String username);
}

package com.au.mongodb.service.UserImplementations;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.mongodb.Repository.BaseAccountRepository;
import com.au.mongodb.model.BaseAccount;
import com.au.mongodb.model.Transaction;
import com.au.mongodb.model.User;
import com.au.mongodb.service.BaseAccountService;
import com.au.mongodb.service.TransactionService;
import com.au.mongodb.service.UserService;

@Service
public class BaseAccountServiceImpl implements  BaseAccountService
{
	@Autowired
	BaseAccountRepository baseaccountrepository;
	
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;
    
    private static int nextAccountNumber = 370226182;
	
	public BaseAccount getbyAccountnumber(int accountNumber)
	{
		
		BaseAccount b=baseaccountrepository.findByAccountNumber(accountNumber);
		
		return b;
	}
	 private int accountGen() {
	        return ++nextAccountNumber;
	    }
	
	public BaseAccount createBankAccount()
	{
		BaseAccount baseAccount = new BaseAccount();
        baseAccount.setAccountBalance(new BigDecimal(0.0));
        baseAccount.setAccountNumber(accountGen()); 
        baseaccountrepository.save(baseAccount);
        return baseaccountrepository.findByAccountNumber(baseAccount.getAccountNumber());
		
		
	}

	
	public void deposit(double amount,String username)
	{
		        User user = userService.findUserByUsername(username);
	            BaseAccount baseAccount = user.getBA();
	            baseAccount.setAccountBalance(baseAccount.getAccountBalance().add(new BigDecimal(amount)));
	            baseaccountrepository.save(baseAccount);

	            Date date = new Date();

	            Transaction Transaction= new Transaction(date, "Deposit to bank Account","self deposit","Finished", amount, baseAccount.getAccountBalance(), baseAccount);
	           transactionService.saveDepositTransaction(Transaction);
	        
		
	}

	
	public void withdraw(double amount, String username)
	{
		User user = userService.findUserByUsername(username);

        
            BaseAccount baseAccount = user.getBA();
            baseAccount.setAccountBalance(baseAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            baseaccountrepository.save(baseAccount);

            Date date = new Date();

            Transaction Transaction = new Transaction(date, "Withdraw from Primary Account", "selfwithdraw", "Finished", amount, baseAccount.getAccountBalance(), baseAccount);
            transactionService.saveWithdrawTransaction(Transaction);
        
    }
	
}

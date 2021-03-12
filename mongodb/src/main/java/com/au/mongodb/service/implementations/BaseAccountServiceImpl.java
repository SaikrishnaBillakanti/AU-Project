package com.au.mongodb.service.implementations;

import java.math.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.au.mongodb.model.BaseAccount;
import com.au.mongodb.model.Transaction;
import com.au.mongodb.model.User;
import com.au.mongodb.repository.BaseAccountRepository;
import com.au.mongodb.repository.UserRepository;
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
    
    @Autowired
	UserRepository userrepository;
    
    private static int nextAccountNumber = 370226259;
    public  static final String MES="finished";
	
	public BaseAccount getbyAccountnumber(int accountNumber)
	{
		return baseaccountrepository.findByAccountNumber(accountNumber);
	}
	 private int accountGen() {
	        return nextAccountNumber+18;
	    }
	
	public BaseAccount createBankAccount()
	{
		BaseAccount baseAccount = new BaseAccount();
        baseAccount.setAccountBalance(BigDecimal.valueOf(0.0));
        baseAccount.setAccountNumber(accountGen()+10); 
        List<Transaction> transactionlist=new ArrayList<>();
        baseAccount.setTransactionList(transactionlist); 
        baseaccountrepository.save(baseAccount);
        return baseaccountrepository.findByAccountNumber(baseAccount.getAccountNumber());
		
		
	}

	
	public String deposit(double amount,String username)
	{
		        User user = userService.findUserByUsername(username);
		        if(user==null)
		        	return "Incorrect Username";
	            BaseAccount baseAccount = user.getBankaccount();
	            baseAccount.setAccountBalance(baseAccount.getAccountBalance().add(BigDecimal.valueOf(amount)));	           	           
	            Date date = new Date();
	            Transaction transaction= new Transaction(date, "Deposit to bankAccount","self deposit",MES, amount, baseAccount.getAccountBalance());
	            baseAccount.getTransactionList().add(transaction);
	            transactionService.saveDepositTransaction(transaction);	            	            	  
	            userrepository.save(user);  
	            
	          return "deposited successfully";
    }
	public String accountdeposit(double amount,String senderusername,String recipient,String description)
	{
		 User user = userService.findUserByUsername(senderusername);        
         BaseAccount baseAccount = user.getBankaccount();
         baseAccount.setAccountBalance(baseAccount.getAccountBalance().subtract(BigDecimal.valueOf(amount)));
          Date date = new Date();
         Transaction transaction = new Transaction(date,description, "debit", MES, amount, baseAccount.getAccountBalance());
         baseAccount.getTransactionList().add(transaction);
         transactionService.saveWithdrawTransaction(transaction);
         userrepository.save(user);
         User ruser = userService.findUserByUsername(recipient);
         if(ruser==null)
        	 return "recipient notfound";
         BaseAccount rbaseAccount = ruser.getBankaccount();
         rbaseAccount.setAccountBalance(rbaseAccount.getAccountBalance().add(BigDecimal.valueOf(amount)));	           	           
         Transaction rtransaction= new Transaction(date,description,"credit from"+senderusername ,MES, amount, rbaseAccount.getAccountBalance());
         rbaseAccount.getTransactionList().add(rtransaction);
         transactionService.saveDepositTransaction(rtransaction);	            	            	  
         userrepository.save(ruser);
         
         return "amount sent Successfully";
	}

	
	public void withdraw(double amount, String username)
	{		
		    User user = userService.findUserByUsername(username);        
            BaseAccount baseAccount = user.getBankaccount();
            baseAccount.setAccountBalance(baseAccount.getAccountBalance().subtract(BigDecimal.valueOf(amount)));
             Date date = new Date();
            Transaction transaction = new Transaction(date, "Withdraw from bankAccount", "selfwithdraw", MES, amount, baseAccount.getAccountBalance());
            baseAccount.getTransactionList().add(transaction);
            transactionService.saveWithdrawTransaction(transaction);
            userrepository.save(user);
           
        
    }
	
}

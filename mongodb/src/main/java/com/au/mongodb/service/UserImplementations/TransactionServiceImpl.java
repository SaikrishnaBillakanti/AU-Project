package com.au.mongodb.service.UserImplementations;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.mongodb.Repository.BaseAccountRepository;
import com.au.mongodb.Repository.RecipientRepository;
import com.au.mongodb.Repository.TransactionRepository;
import com.au.mongodb.model.BaseAccount;
import com.au.mongodb.model.Recipient;
import com.au.mongodb.model.Transaction;
import com.au.mongodb.model.User;
import com.au.mongodb.service.TransactionService;
import com.au.mongodb.service.UserService;

@Service
public class TransactionServiceImpl implements TransactionService 
{

	    @Autowired
	    private UserService userService;

	    @Autowired
	    private TransactionRepository Transactionrepository;

	   
	   
	    @Autowired
	    private BaseAccountRepository baseaccountrepository;

	    @Autowired
	    private RecipientRepository recipientrepository;


	    public List<Transaction> findTransactionList(String username) 
	    {
	        User user = userService.findUserByUsername(username);
	        List<Transaction> TransactionList = user.getBA().getTransactionList();

	        return TransactionList;
	    }

	   
	    public void saveDepositTransaction(Transaction Transaction) {
	        Transactionrepository.save(Transaction);
	    }

	   
	    public void saveWithdrawTransaction(Transaction Transaction) {
	    	Transactionrepository.save(Transaction);
	    }

	   
}	 
		

		





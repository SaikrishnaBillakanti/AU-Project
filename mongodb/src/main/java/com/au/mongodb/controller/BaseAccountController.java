package com.au.mongodb.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.au.mongodb.Repository.BaseAccountRepository;
import com.au.mongodb.model.BaseAccount;
import com.au.mongodb.model.Transaction;
import com.au.mongodb.model.User;
import com.au.mongodb.service.BaseAccountService;
import com.au.mongodb.service.TransactionService;
import com.au.mongodb.service.UserService;

@Controller
@RequestMapping("/account")
public class BaseAccountController
{

	    @Autowired
	    private UserService userService;

	    @Autowired
	    private BaseAccountService baseaccountService;

	    @Autowired
	    private TransactionService transactionService;
	    
	    @Autowired
	    BaseAccountRepository baseaccountrepository;

	    
	    public BaseAccount baseAccount(String username)
	    {
	        List<Transaction> TransactionList = transactionService.findTransactionList(username);

	        User user = userService.findUserByUsername(username);
	        BaseAccount baseAccount =user.getBA();
	        baseAccount.setTransactionList(TransactionList);
	        return baseAccount;
	    }

	
}

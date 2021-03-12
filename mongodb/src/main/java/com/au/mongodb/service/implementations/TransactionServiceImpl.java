package com.au.mongodb.service.implementations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.au.mongodb.model.Transaction;
import com.au.mongodb.repository.TransactionRepository;
import com.au.mongodb.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService 
{

	    @Autowired
	    private TransactionRepository transactionrepository;
	    
	    public void saveDepositTransaction(Transaction transaction)
	    {
	    	transactionrepository.save(transaction);    
	    }
	    public void saveWithdrawTransaction(Transaction transaction) {
	    	transactionrepository.save(transaction);
	    }

	   
}	 
		

		





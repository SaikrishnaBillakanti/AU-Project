package com.au.mongodb.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.au.mongodb.model.BaseAccount;

public interface BaseAccountRepository extends MongoRepository<BaseAccount,String>
{
	//BaseAccount findAccountByAccountnumber(int accountNumber);

	BaseAccount findByAccountNumber(int accountnumber);


}

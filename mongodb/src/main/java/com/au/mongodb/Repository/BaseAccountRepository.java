package com.au.mongodb.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.au.mongodb.model.BaseAccount;

public interface BaseAccountRepository extends MongoRepository<BaseAccount,String>
{
	BaseAccount findByAccountNumber(int accountnumber);
}

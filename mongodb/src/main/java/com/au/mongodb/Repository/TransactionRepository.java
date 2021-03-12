package com.au.mongodb.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.au.mongodb.model.Transaction;

public interface TransactionRepository extends MongoRepository <Transaction,String> {

	List<Transaction> findAll();
}

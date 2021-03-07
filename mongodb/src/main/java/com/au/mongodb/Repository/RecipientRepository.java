package com.au.mongodb.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.au.mongodb.model.Recipient;

public interface RecipientRepository extends MongoRepository <Recipient,String>
{
	List<Recipient> findAll();

    Recipient findByName(String recipientName);

    void deleteByName(String recipientName);
}

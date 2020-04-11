package com.example.demo_historical.service;

import com.example.demo_historical.entity.Transaction;

public interface ITransactionService {
	
	public Transaction save ( Transaction transaction );
	public Iterable<Transaction> findByAccountID(Integer accountId);
	public Iterable<Transaction> findAll();

}

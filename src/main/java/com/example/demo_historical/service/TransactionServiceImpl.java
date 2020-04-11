package com.example.demo_historical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_historical.entity.Transaction;
import com.example.demo_historical.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired
	private TransactionRepository repository;

	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return repository.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByAccountID(Integer accountId) {
		// TODO Auto-generated method stub
		return  repository.findByAccountId(accountId);
	}

	@Override
	public Iterable<Transaction> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}

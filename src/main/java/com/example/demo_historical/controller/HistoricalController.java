package com.example.demo_historical.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_historical.entity.Transaction;
import com.example.demo_historical.kafka.consumer.listener.TransactionEventConsumer;
import com.example.demo_historical.service.ITransactionService;

@RestController
public class HistoricalController {
	
	private Logger log = LoggerFactory.getLogger(HistoricalController.class) ;
	
	@Autowired
	private ITransactionService transaction;
	
	@GetMapping("/transaction/{accountId}")
	public ResponseEntity<?> obtenerTransacciones(@PathVariable Integer accountId){
		log.info("id : {} ", transaction.findByAccountID(accountId));
		Iterable<Transaction> itransaction = transaction.findByAccountID(accountId);
		
		return ResponseEntity.ok(itransaction);
	}
	
	@GetMapping("/listar")
	public List<Transaction> listar(){
		return (List<Transaction>)transaction.findAll();
	}
	
	

}

package com.example.demo_historical.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_historical.entity.Transaction;
import com.example.demo_historical.repository.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class TransactionEvents {

	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	
	@Autowired
	 private TransactionRepository repository;
	
	@Autowired
	ObjectMapper objectMapper;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		
		double newmonto = 0;
		
		Transaction objAccount = new Transaction();
		// Account objAccount = new Account();
		Transaction transactionEvent = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		log.info("transactionEvent : {} ", transactionEvent);
		
		repository.save(transactionEvent);
		
		log.info("Successfully Persisted the transaction Event {} ", transactionEvent.getId());
		
		//	log.info("transactionEvent : {} ", transactionEvent.getAccountId());
		//objAccount = repository.findById(transactionEvent.getAccountId());
		//log.info("get amout : ", objAccount.getTotalAmount());
/*
		switch (transactionEvent.getType()) {
		case "deposito":
			newmonto = objAccount.getTotalAmount() + transactionEvent.getAmount();
			break;
		case "retiro":
			newmonto = objAccount.getTotalAmount() - transactionEvent.getAmount();
			break;
		default:
			log.info("Invalid Library Event type");
		}
		
		log.info("set new amount {}",newmonto);
		objAccount.setTotalAmount(newmonto);
		repository.save(objAccount);
		*/
	}
	
	
	
}

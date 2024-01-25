package com.demo.dynamodb.service;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.demo.dynamodb.model.TransactionDetails;
import com.demo.dynamodb.repository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamoDbService {

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    public List<TransactionDetails> fetchAll() {
        return (List<TransactionDetails>) transactionDetailsRepository.findAll();
    }

    public TransactionDetails find(String id) {
        return transactionDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found" + id));
    }

    public TransactionDetails saveTransactionDetails(TransactionDetails transactionDetails) {
        return transactionDetailsRepository.save(transactionDetails);
    }

    public TransactionDetails update(String id, TransactionDetails transactionDetails) {
        transactionDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found" + id));

        transactionDetails.setId(id);
        return transactionDetailsRepository.save(transactionDetails);
    }


    public void deleteTransaction(String id) {
        transactionDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found" + id));

        transactionDetailsRepository.deleteById(id);;
    }
}

package com.demo.dynamodb.controller;

import com.demo.dynamodb.model.TransactionDetails;
import com.demo.dynamodb.service.DynamoDbService;
import com.demo.dynamodb.service.DynamoDbUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DynamoDbController {

    @Autowired
    DynamoDbService dynamoDbService;

    @Autowired
    DynamoDbUpdateService dynamoDbUpdateService;

    @GetMapping(path = "/transactions")
    public List<TransactionDetails> fetchAllTransactions() {
        return dynamoDbService.fetchAll();
    }

    @GetMapping(path = "/transaction/{id}")
    public TransactionDetails fetchTransaction(@PathVariable String id) {
        return dynamoDbService.find(id);
    }

    @PostMapping(path = "/transaction/save")
    public TransactionDetails saveTransaction(@RequestBody TransactionDetails transactionDetails) {
        return dynamoDbService.saveTransactionDetails(transactionDetails);
    }

    @PutMapping(path = "/transaction/update/{id}")
    public TransactionDetails updateTransaction(@PathVariable String id, @RequestBody TransactionDetails transactionDetails) {
        return dynamoDbService.update(id, transactionDetails);
    }

    @PutMapping(path = "/transaction/updateV2")
    public void updateTransactionV2(@RequestBody TransactionDetails transactionDetails) {
        dynamoDbUpdateService.updateV2(transactionDetails);
    }

    @DeleteMapping(path = "/transaction/{id}")
    public void deleteTransaction(@PathVariable String id) {
        dynamoDbService.deleteTransaction(id);
    }
}

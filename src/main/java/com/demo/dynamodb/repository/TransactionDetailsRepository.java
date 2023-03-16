package com.demo.dynamodb.repository;

import com.demo.dynamodb.model.TransactionDetails;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface TransactionDetailsRepository extends CrudRepository <TransactionDetails, String> {
}

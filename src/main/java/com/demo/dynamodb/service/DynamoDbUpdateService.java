package com.demo.dynamodb.service;

import com.demo.dynamodb.model.TransactionDetails;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;

import java.util.HashMap;
import java.util.Map;

@Service
public class DynamoDbUpdateService {

    public void updateV2(TransactionDetails transactionDetails) {
        // Create a DynamoDB client
        DynamoDbClient dynamoDbClient = DynamoDbClient.create();

        // Specify the table name and primary key
        String tableName = "transaction_details";
        String primaryKey = transactionDetails.getId();

        // Specify the update expression and attribute values
        String updateExpression = "SET bene_name = :bene_name, amount = :amount";
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":bene_name", AttributeValue.builder().s(transactionDetails.getBeneName()).build());
        expressionAttributeValues.put(":amount", AttributeValue.builder().s(String.valueOf(transactionDetails.getAmount())).build());


        // Build the update item request
        UpdateItemRequest updateItemRequest = UpdateItemRequest.builder()
                .tableName(tableName)
                .key(Map.of("id", AttributeValue.builder().s(primaryKey).build()))
                .updateExpression(updateExpression)
                .expressionAttributeValues(expressionAttributeValues)
                .returnValues("UPDATED_NEW")  // Optional: specify if you want to get the updated item attributes
                .build();

        // Perform the update without fetching the item first
        dynamoDbClient.updateItem(updateItemRequest);

        // Close the DynamoDB client
        dynamoDbClient.close();
    }

}

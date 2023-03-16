package com.demo.dynamodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamodbApplication {

	public static void main(String[] args) {
		System.out.println("Hello");
		SpringApplication.run(DynamodbApplication.class, args);
	}

}

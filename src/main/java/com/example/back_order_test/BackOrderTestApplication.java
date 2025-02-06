package com.example.back_order_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(scanBasePackages = "com.example.back_order_test")
@EnableR2dbcRepositories(basePackages = "com.example.back_order_test.repository.r2dbc")
@EnableReactiveMongoRepositories(basePackages = "com.example.back_order_test.repository.mongo")
public class BackOrderTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackOrderTestApplication.class, args);
	}

}

package com.trading.income;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IncomeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncomeServiceApplication.class, args);
	}

}

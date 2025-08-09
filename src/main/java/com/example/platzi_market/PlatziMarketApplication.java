package com.example.platzi_market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.platzi_market.persistence.crud")
@EntityScan(basePackages = "com.example.platzi_market.persistence.entities")
@EnableTransactionManagement
public class PlatziMarketApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlatziMarketApplication.class, args);
	}
}
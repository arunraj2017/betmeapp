package com.bet.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableScheduling
@EnableMongoRepositories
@EnableTransactionManagement
public class BetMeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetMeAppApplication.class, args);
	}

}

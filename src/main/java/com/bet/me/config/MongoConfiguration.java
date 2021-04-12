package com.bet.me.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfiguration {

	@Value("${connection}")
	private String mongoConnectionString;

	@Bean
	public MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString(mongoConnectionString);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(),
				this.mongoConnectionString.substring(this.mongoConnectionString.lastIndexOf("/") + 1).trim());
	}

}

package com.gi.hrm.config.internal;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {
	private final Environment env;

	public MongoConfig(Environment env) {
		super();
		this.env = env;
	}

	@Override
	public MongoClient reactiveMongoClient() {
		return MongoClients.create();
	}

	@Override
	protected String getDatabaseName() {
		return env.getProperty("spring.data.mongodb.database");
	}
}

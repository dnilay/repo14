package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.example.demo.entity.Person;

@Configuration
public class DynamoDBConfig {

	public static final String REGION = "ap-southeast-1";
	public static final String ACCESS_KEY = "AKIA44QDHYG5HN6N7MGW";
	public static final String SECRET_KEY = "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";

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials())).withRegion(REGION).build();
		DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client, DynamoDBMapperConfig.DEFAULT);
		init(dynamoDBMapper, client);
		return dynamoDBMapper;
	}

	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
	}

	public void init(DynamoDBMapper dynamoDBMapper, AmazonDynamoDB client) {

		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Person.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

		if (TableUtils.createTableIfNotExists(client, tableRequest)) {
			System.out.println("Table created");
		}

	}
}

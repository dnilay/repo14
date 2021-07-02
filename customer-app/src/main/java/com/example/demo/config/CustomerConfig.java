package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;

@Configuration
public class CustomerConfig {

	
	@Bean
	public Map<Integer, Customer> customerMap()
	{
		return new HashMap<Integer,Customer>();
	}
}

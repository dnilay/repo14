package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeerServiceAppApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BeerServiceAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}

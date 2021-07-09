package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

	private Environment environment;

	@Autowired
	public BeerController(Environment environment) {
		this.environment = environment;
	}
	@GetMapping
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("beerservice-app is up and running on port: "+environment.getProperty("local.server.port"));
	}
	
}

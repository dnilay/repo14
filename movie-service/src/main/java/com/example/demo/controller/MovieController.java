package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovieController {
	
	private Environment environment;

	public MovieController(Environment environment) {
		log.info("di done");
		this.environment = environment;
	}
	
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("movie app is up and running on port: "+environment.getProperty("local.server.port"));
	}
	

}

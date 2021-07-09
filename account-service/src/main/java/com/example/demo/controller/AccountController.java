package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;

import lombok.Builder;

@RestController

public class AccountController {

	
	private Environment environment;

	@Autowired
	public AccountController(Environment environment) {
		this.environment = environment;
	}
	
	@GetMapping("/")
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("appliction is up and running on port number: "+environment.getProperty("local.server.port"));
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<Account> displayAccount()
	{
		Account account=Account.builder().accountId(UUID.randomUUID().toString())
				.accountHolderName("John Doe").balance(10000.0)
				.isActive(true).build();
		return ResponseEntity.status(HttpStatus.OK).body(account);
	}
	
	
}

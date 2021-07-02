package com.example.demo.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController

public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		
		this.customerService = customerService;
	}
	
	
	public ResponseEntity<Customer> createCustomer()
	{
		return null;
	}
	@GetMapping("/api/customers")
	public ResponseEntity<Collection<Customer>> displayAllCustomers()
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.displayAllCustomer());
	}
	@GetMapping("/api/customers/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.findCustomerById(id));
	}
	
	
	
	
	
	
	
	
}

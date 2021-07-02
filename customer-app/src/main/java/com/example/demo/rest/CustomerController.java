package com.example.demo.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController

public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		
		this.customerService = customerService;
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException e)

	{
		CustomerErrorResponse response=new CustomerErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setErrorLogTime(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleNumberFormatException(NumberFormatException e)
	{
		CustomerErrorResponse response=new CustomerErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setErrorLogTime(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	@PostMapping("/api/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
	}
	@GetMapping("/api/customers")
	public ResponseEntity<Collection<Customer>> displayAllCustomers()
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.displayAllCustomer());
	}
	@GetMapping("/api/customers/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Integer id) throws NumberFormatException
	{
		Customer customer=customerService.findCustomerById(id);
		if(customer==null)
		{
			throw new CustomerNotFoundException("customer with the "+id+" not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(customerService.findCustomerById(id));
	}
	
	
	
	
	
	
	
	
}

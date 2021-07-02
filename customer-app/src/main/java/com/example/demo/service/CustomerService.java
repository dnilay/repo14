package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Customer;

public interface CustomerService {
public Customer createCustomer(Customer customer);
	
	public Collection<Customer> displayAllCustomer();
	public Customer findCustomerById(Integer id);
	public Customer updateCustomer(Customer customer,Integer customerId);


}

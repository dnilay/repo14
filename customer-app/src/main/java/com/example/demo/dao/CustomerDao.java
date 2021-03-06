package com.example.demo.dao;

import java.util.Collection;

import com.example.demo.model.Customer;

public interface CustomerDao {
	
	public Customer createCustomer(Customer customer);
	
	public Collection<Customer> displayAllCustomer();
	
	public Customer findCustomerById(Integer id);
	public Customer updateCustomer(Customer customer,Integer customerId);
	
	

}

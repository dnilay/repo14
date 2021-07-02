package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;
@Component
public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		
		this.customerDao = customerDao;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.createCustomer(customer);
	}

	@Override
	public Collection<Customer> displayAllCustomer() {
		// TODO Auto-generated method stub
		return customerDao.displayAllCustomer();
	}

	@Override
	public Customer findCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerById(id);
	}

}

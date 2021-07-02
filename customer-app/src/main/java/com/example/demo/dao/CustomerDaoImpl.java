package com.example.demo.dao;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao {

	private Map<Integer, Customer> customerMap;

	@Autowired
	public CustomerDaoImpl(Map<Integer, Customer> customerMap) {

		this.customerMap = customerMap;
		customerMap.put(new Random().nextInt(1000),
				new Customer(UUID.randomUUID().toString(), "John", "Doe", "john#email.com"));
		customerMap.put(new Random().nextInt(1000),
				new Customer(UUID.randomUUID().toString(), "Marry", "Public", "marry@email.com"));
		System.out.println(customerMap);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setCustomerId(UUID.randomUUID().toString());
		customerMap.put(new Random().nextInt(10000), customer);
		System.out.println(customerMap);
		return customer;
	}

	@Override
	public Collection<Customer> displayAllCustomer() {
		// TODO Auto-generated method stub
		return customerMap.values();
	}

	@Override
	public Customer findCustomerById(Integer id) {
		Customer customer = customerMap.get(id);
		return customer;
	}

}

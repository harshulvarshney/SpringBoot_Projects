package com.java.ecomm.customer.service;

import java.util.List;

import com.java.ecomm.customer.domain.Customer;

public interface CustomerService {
	
	Customer getCustomerByName(String name);
	
	void addCustomer(Customer customer);
	
	List<Customer> getAllCustomers();

}

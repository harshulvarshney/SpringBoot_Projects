package com.java.ecomm.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.ecomm.customer.domain.Customer;
import com.java.ecomm.customer.repo.CustomerRepository;
import com.java.ecomm.customer.service.CustomerService;

/**
 * 
 * @author harshul.varshney
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repo;

	@Override
	@Transactional(readOnly = true)
	public Customer getCustomerByName(String name) {
		return repo.getCustomerByName(name);
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		repo.save(customer);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

}

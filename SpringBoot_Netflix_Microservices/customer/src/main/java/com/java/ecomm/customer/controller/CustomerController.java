package com.java.ecomm.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.ecomm.customer.domain.Customer;
import com.java.ecomm.customer.service.CustomerService;


/**
 * 
 * @author harshul.varshney
 *
 */
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		try {
			
			List<Customer> customers = customerService.getAllCustomers();
			if(customers != null)
				return ResponseEntity.status(HttpStatus.OK).body(customers);
			
		} catch(Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@GetMapping("customer/{name}")
	public ResponseEntity<Customer> getCustomerDetail(@PathVariable String name) {
		try {
			
			Customer customer = customerService.getCustomerByName(name);
			if(customer != null)
				return ResponseEntity.status(HttpStatus.OK).body(customer);
			
		} catch(Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PostMapping("customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		try {
			customerService.addCustomer(customer);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(customer);
		} catch(Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

}

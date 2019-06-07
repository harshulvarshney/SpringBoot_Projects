package com.java.ecomm.customer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.ecomm.customer.domain.Customer;

/**
 * 
 * @author harshul.varshney
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer getCustomerByName(String name);
	
	List<Customer> findAll();
	
	Customer save(Customer customer);

}

package com.java.ecomm.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.ecomm.warehouse.dto.Product;
import com.java.ecomm.warehouse.dto.ProductCategory;
import com.java.ecomm.warehouse.service.WarehouseService;

/**
 * 
 * @author harshul.varshney
 *
 */
@RestController
public class WarehouseController {
	
	@Autowired
	private WarehouseService service;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("products/add/{productId}/{category}/{quantity}")
	public ResponseEntity addProduct(@PathVariable String productId, 
			@PathVariable String category,
			@PathVariable Integer quantity) {
		
		if(service.addProduct(productId, quantity, ProductCategory.valueOf(category)))
			ResponseEntity.status(HttpStatus.OK).body(null);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@GetMapping("products/available/{productId}")
	public ResponseEntity<Product> checkProductAvailability(@PathVariable String productId) {
		
		try {
			Product p = service.checkProductAvailability(productId);
			return ResponseEntity.status(HttpStatus.OK).body(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping("products/ship/{productId}/{quantity}")
	public ResponseEntity<Boolean> sendProductToShipping(String productId, Integer quantity) {
		
		boolean sent = service.sendProductToShipping(productId, quantity);
		if(sent)
			ResponseEntity.status(HttpStatus.OK).body(null);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

}

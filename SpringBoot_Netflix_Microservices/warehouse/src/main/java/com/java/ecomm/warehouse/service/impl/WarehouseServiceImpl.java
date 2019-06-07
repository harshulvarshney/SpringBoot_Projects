package com.java.ecomm.warehouse.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.java.ecomm.warehouse.dto.Product;
import com.java.ecomm.warehouse.dto.ProductCategory;
import com.java.ecomm.warehouse.repo.ProductsRepository;
import com.java.ecomm.warehouse.service.WarehouseService;

/**
 * 
 * @author harshul.varshney
 *
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
	
	@Autowired private ProductsRepository repository;
	@Autowired private Environment env;
	
	private static final String PORT = "server.port";

	@Override
	public boolean addProduct(String productId, Integer quantity, ProductCategory category) {
		return repository.addProduct(productId, quantity, category);
	}

	@Override
	public Product checkProductAvailability(String productId) {
//		return repository.checkProductAvailability(productId);
		Random r = new Random();
		int qty= r.nextInt(5);
		Product p = new Product();
		p.setProductId(productId);
		p.setProductCategory(ProductCategory.PHONE);
		p.setQuantity(qty);
		p.setPort(Integer.parseInt(env.getProperty(PORT)));
		return p;
	}

	@Override
	public boolean sendProductToShipping(String productId, Integer quantity) {
		//TODO: implement business logic
		return false;
	}

}

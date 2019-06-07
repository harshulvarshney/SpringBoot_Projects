package com.java.ecomm.warehouse.service;

import com.java.ecomm.warehouse.dto.Product;
import com.java.ecomm.warehouse.dto.ProductCategory;

public interface WarehouseService {
	
	boolean addProduct(String productId, Integer quantity, ProductCategory category);
	
	Product checkProductAvailability(String productId);
	
	boolean sendProductToShipping(String productId, Integer quantity);

}

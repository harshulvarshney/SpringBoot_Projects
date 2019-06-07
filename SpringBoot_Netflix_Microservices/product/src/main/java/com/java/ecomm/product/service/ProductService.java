package com.java.ecomm.product.service;

import java.util.List;

import com.java.ecomm.product.model.ProductModel;

public interface ProductService {

	/**
	 * Creates new Product entity in DB.
	 * 
	 * @param Product
	 * @return
	 */
	public ProductModel addProduct(ProductModel Product);
	
	/**
	 * Returns a product based on product-key
	 * 
	 * @return
	 */
	public List<ProductModel> findByName(String key);

	/**
	 * Returns all Product entities from DB.
	 * 
	 * @return
	 */
	public List<ProductModel> findAll();

	/**
	 * Returns a Product by the ID passed.
	 * 
	 * @param id
	 */
	public ProductModel findByProductCode(String id);

	/**
	 * Deletes a Product recird by ID from DB.
	 * 
	 * @param id
	 */
	public void delete(String id);

}

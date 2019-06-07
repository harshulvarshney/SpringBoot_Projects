package com.java.ecomm.product.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.ecomm.product.facade.ProductSearchFacade;
import com.java.ecomm.product.model.ProductModel;
import com.java.ecomm.product.service.ProductService;

/**
 * 
 * @author harshul.varshney
 *
 */
@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired private ProductService productService;
	@Autowired private ProductSearchFacade productSearchFacade;
	@Autowired private Environment env;
	
	/**
	 * returns all products available in DB.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductModel>> getAllProducts() {
		List<ProductModel> products = null;
		try {
			products = productService.findAll();
			return ResponseEntity.ok(products);
		} catch(Exception e) {
			System.out.println("Exception occured " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	/**
	 * Adds a product to DB
	 * @param product
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel product) {
		try {
			product = productService.addProduct(product);
			
			if(product != null)
				return ResponseEntity.status(HttpStatus.CREATED).body(product);
			
		} catch(Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	public ResponseEntity<List<ProductModel>> findByName(@PathVariable("name") String name) {
		List<ProductModel> products = null;
		try {
			products = productSearchFacade.searchProduct(name);
			products.stream().forEach(p -> p.setPort(Integer.parseInt(env.getProperty("server.port"))));
			if(CollectionUtils.isNotEmpty(products))
				return ResponseEntity.status(HttpStatus.OK).body(products);
			
		} catch(Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	/**
	 * Delete product by id
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{productCode}")
	public ResponseEntity deleteProduct(@PathVariable("productCode") String productCode) {
		try {
			ProductModel ProductModel = productService.findByProductCode(productCode);
			
			if(ProductModel != null) {
				productService.delete(productCode);
				return ResponseEntity.status(HttpStatus.OK).body(null);
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch(Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}

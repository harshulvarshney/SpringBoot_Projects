package com.java.ecomm.warehouse.dto;

public class Product {
	
	private String productId;
	private Integer quantity;
	private ProductCategory productCategory;
	
	private int port;
	
	public Product() {
		
	}
	
	public Product(String prodId, int quantity, String productCategory) {
		this.productId = prodId;
		this.quantity = quantity;
		this.productCategory = ProductCategory.valueOf(productCategory);
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}

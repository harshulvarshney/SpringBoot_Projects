package com.java.ecomm.product.model;

import java.math.BigDecimal;

public class ProductModel {
	
	private String 			name;
	private String 			productCode;
	private ProductFamily 	productFamily;
	private boolean 		available;
	private BigDecimal 		price;
	private Integer			availableQuantity;
	
	private int 			port;//for visibility purpose only
	private int				warehouse_service_port;//for testing ribbon client functionality
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductFamily getProductFamily() {
		return productFamily;
	}
	public void setProductFamily(ProductFamily productFamily) {
		this.productFamily = productFamily;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getWarehouse_service_port() {
		return warehouse_service_port;
	}
	public void setWarehouse_service_port(int warehouse_service_port) {
		this.warehouse_service_port = warehouse_service_port;
	}

}

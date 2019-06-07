package com.java.ecomm.product.domain;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.java.ecomm.product.model.ProductFamily;

/**
 * 
 * @author harshul.varshney
 *
 */
@Document(collection = "products")
public class Product {
	
	@Indexed(unique = false)
	private String name;
	
	private ProductFamily productFamily;
	private String productCode;
	private boolean available;
	private BigDecimal price;
			 
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

}

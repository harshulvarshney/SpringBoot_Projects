package com.java.ecomm.warehouse.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.java.ecomm.warehouse.dto.Product;
import com.java.ecomm.warehouse.dto.ProductCategory;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		
		product.setProductId(rs.getString("product_id"));
		product.setQuantity(rs.getInt("quantity"));
		product.setProductCategory(ProductCategory.valueOf(rs.getString("product_category")));
		
		return product;
	}

}

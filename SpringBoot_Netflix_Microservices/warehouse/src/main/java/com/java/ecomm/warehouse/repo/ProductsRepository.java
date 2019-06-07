package com.java.ecomm.warehouse.repo;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.ecomm.warehouse.dto.Product;
import com.java.ecomm.warehouse.dto.ProductCategory;

/**
 * 
 * @author harshul.varshney
 *
 */
@Repository
public class ProductsRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> findAll() {

        List<Product> result = jdbcTemplate.query(
                "SELECT * FROM product",
                (rs, rowNum) -> new Product(rs.getString("product_id"),
                							rs.getInt("quantity"),
                							rs.getString("product_category")
        ));

        return result;

    }
	
	public int checkProductAvailability(String productId) {
		String sql = "SELECT quantity FROM product WHERE product_id = ?";
		int availableQuantity = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return availableQuantity;
	}
	
	public boolean addProduct(String productId, Integer quantity, ProductCategory category) {
		
		String insertSql = "insert into product (product_id, quantity, product_category) valuse (?, ?, ?)";
		Object[] params = new Object[] { productId, quantity, category.toString()};
		int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR };

		int row = jdbcTemplate.update(insertSql, params, types);
		
		return row == 1 ? true : false;
	}


}

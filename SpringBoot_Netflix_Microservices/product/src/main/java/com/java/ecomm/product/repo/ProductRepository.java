package com.java.ecomm.product.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.ecomm.product.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
	
	Product save(Product product);
	
	List<Product> findAll();
	
	@Query("{ 'productCode' : ?0 }")
	Product findByProductCode(String productCode);
	
	@Query("{ 'name' : ?0 }")
	List<Product> findByName(String name);

	@Query(value="{'productCode' : ?0}", delete = true)
	void deleteByProductCode(String productCode);
}

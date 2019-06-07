package com.java.ecomm.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.ecomm.product.domain.Product;
import com.java.ecomm.product.model.ProductModel;
import com.java.ecomm.product.orika.mapper.ProductOrikaMapper;
import com.java.ecomm.product.repo.ProductRepository;
import com.java.ecomm.product.service.ProductService;

/**
 * 
 * @author harshul.varshney
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired ProductRepository productRepository;

	@Override
	public ProductModel addProduct(ProductModel productModel) {
		Product product = ProductOrikaMapper.getOrikaMapper().map(productModel, Product.class);
		productRepository.save(product);
		return ProductOrikaMapper.getOrikaMapper().map(product, ProductModel.class);
	}

	@Override
	public List<ProductModel> findAll() {
		List<Product> products = productRepository.findAll();
		return ProductOrikaMapper.getOrikaMapper().mapAsList(products, ProductModel.class);
	}

	@Override
	public ProductModel findByProductCode(String code) {
		Product pro = productRepository.findByProductCode(code);
		return ProductOrikaMapper.getOrikaMapper().map(pro, ProductModel.class);
	}

	@Override
	public void delete(String code) {
		Product product = productRepository.findByProductCode(code);
		productRepository.deleteByProductCode(product.getProductCode());
	}

	@Override
	public List<ProductModel> findByName(String name) {
		List<Product> pro = productRepository.findByName(name);
		return ProductOrikaMapper.getOrikaMapper().mapAsList(pro, ProductModel.class);
	}
	
	

}

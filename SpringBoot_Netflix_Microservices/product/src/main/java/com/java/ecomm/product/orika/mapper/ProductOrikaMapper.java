package com.java.ecomm.product.orika.mapper;

import com.java.ecomm.product.domain.Product;
import com.java.ecomm.product.model.ProductModel;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ProductOrikaMapper {
	static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	static {
		mapperFactory.classMap(Product.class, ProductModel.class)
		   .byDefault()
		   .register();
	}

	public static MapperFacade getOrikaMapper() {
		return mapperFactory.getMapperFacade();
	}
}

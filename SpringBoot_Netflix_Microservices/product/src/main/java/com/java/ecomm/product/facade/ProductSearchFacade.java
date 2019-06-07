package com.java.ecomm.product.facade;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.java.ecomm.product.model.ProductModel;
import com.java.ecomm.product.model.WarehouseProduct;
import com.java.ecomm.product.proxy.WarehouseProxy;
import com.java.ecomm.product.service.ProductService;

/**
 * 
 * @author harshul.varshney
 *
 */
@Component
public class ProductSearchFacade {
	
	@Autowired private ProductService productService;
	@Autowired private WarehouseProxy warehouseProxy;
	
	public List<ProductModel> searchProduct(String name) {
		List<ProductModel> products = productService.findByName(name);
		
		for(ProductModel product : products) {
			if(CollectionUtils.isNotEmpty(products)) {//check for availability
				Optional<WarehouseProduct> warehouseProductBean = checkAvailability(product.getProductCode());
				if(warehouseProductBean.isPresent()) {
					product.setAvailable(warehouseProductBean.get().getQuantity() > 0 ? Boolean.TRUE : Boolean.FALSE);
					product.setWarehouse_service_port(warehouseProductBean.get().getPort());
					product.setAvailableQuantity(warehouseProductBean.get().getQuantity());
				}
			}
		}
		
		return products;
	}
	
	private Optional<WarehouseProduct> checkAvailability(String productId) {
		
		ResponseEntity<WarehouseProduct> resp = warehouseProxy.checkProductAvailability(productId);
		return Optional.ofNullable(resp.getBody());
	}

}

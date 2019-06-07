package com.java.ecomm.product.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.ecomm.product.model.WarehouseProduct;

/**
 * 
 * @author harshul.varshney
 * FeignClient is a light weight REST client to call RESTfull services
 * Spring's RESTTemplate could also be used, but with Feign it's much less code to write
 * 
 */
//@FeignClient(name = "warehouse-service", url="localhost:9093") -- used when no naming server available
//@FeignClient(name = "warehouse-service") -- used when product service directly call warehouse service after finding the instance through eureka server
@FeignClient(name = "netflix-zuul-api-gateway")
@RibbonClient(name = "warehouse-service")
public interface WarehouseProxy {
	
	//@GetMapping("products/available/{productId}") - -used without Zuul
	@GetMapping("warehouse-service/products/available/{productId}")
	public ResponseEntity<WarehouseProduct> checkProductAvailability(@PathVariable("productId") String productId);

}

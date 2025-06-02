package com.wipro.ecom.ordermanagement.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")
public interface ProductClient {

	@GetMapping("/product/{id}")
    Map<String, Object> getProductById(@PathVariable("id") int id);

    @PutMapping("/product")
    void updateProductQuantity(@PathVariable int productId, @RequestParam int quantityChange);

}

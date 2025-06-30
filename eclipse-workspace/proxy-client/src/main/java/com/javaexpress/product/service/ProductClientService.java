package com.javaexpress.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaexpress.product.dto.ProductDto;

@FeignClient(name="product-service",contextId="ProductClientService",path="/api/categories")
public interface ProductClientService {
	
	@PostMapping
	public ResponseEntity<ProductDto> save (@RequestBody   ProductDto productDto);


}

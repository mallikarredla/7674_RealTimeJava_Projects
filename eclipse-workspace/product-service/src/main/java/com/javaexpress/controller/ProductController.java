package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.ProductDto;
import com.javaexpress.models.Product;
import com.javaexpress.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/products")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@PostMapping
	public ResponseEntity<ProductDto> save (@RequestBody   ProductDto productDto){
		log.info("product Controller save");
		var result =productService.save(productDto);
		return ResponseEntity.ok(result);
		
	}
	

}

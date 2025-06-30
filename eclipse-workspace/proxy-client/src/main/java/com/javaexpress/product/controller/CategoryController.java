package com.javaexpress.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.product.dto.CategoryDto;
import com.javaexpress.product.service.CategoryClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/categories")
@RestController
public class CategoryController {
	@Autowired
	private CategoryClientService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryDto>save(@RequestBody CategoryDto categoryDto){
		log.info("CategoryController :: save");
		return categoryService.save(categoryDto);
		
		
	}
	@GetMapping
	public ResponseEntity<List<CategoryDto>>findAll(){
		log.info("**** CategoryDto List,controller; fetch all categories *");
		return categoryService.findAll();
		
	}
	

}

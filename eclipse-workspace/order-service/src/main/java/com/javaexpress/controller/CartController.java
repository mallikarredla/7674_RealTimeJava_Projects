package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.CartDto;
import com.javaexpress.service.CartServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/carts")
public class CartController {
  
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public CartDto save(@RequestBody CartDto cartDto) {
		
		
		log.info("CartController:: save");
		return cartServiceImpl.save(cartDto);
		
		
	}
	@GetMapping("{cartId}")
	public CartDto findById(@PathVariable Integer cartId) {
		log.info("CartController findById");

		return cartServiceImpl.findById(cartId);
	}
}

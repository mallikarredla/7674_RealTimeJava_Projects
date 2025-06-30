package com.javaexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.CartDto;
import com.javaexpress.dto.UserDto;
import com.javaexpress.dto.UserDto;
import com.javaexpress.feignclients.UserFeignClient;
import com.javaexpress.helper.CartMappingHelper;
import com.javaexpress.repository.CartRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl {
	@Autowired
	private CartRepository cartRepository;
	 
	@Autowired
	private UserFeignClient userFeignClient;
	
	public CartDto save(CartDto cartDto) {
		log.info("CartServiceImpl:: save");
		cartRepository.save(CartMappingHelper.map(cartDto));
		return CartMappingHelper.map(cartRepository.save(CartMappingHelper.map(cartDto)));
		
		
		
		//saving the Data to DB
	}
	public CartDto findById(Integer cartId) {
		log.info("CartServiceImpl");

		return cartRepository.findById(cartId).map(CartMappingHelper::map)
				.map(obj-> {
				UserDto userDto=userFeignClient.findById(obj.getUserId()).getBody();
		obj.setUserDto(userDto);
		return obj;
				})
.orElseThrow(()->new RuntimeException("CartId not found in Db"));
				}
					
}
	
	


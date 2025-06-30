
package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CartDto;
import com.javaexpress.model.Cart;

public interface CartMappingHelper {
	public static CartDto map(Cart cart) {
		CartDto cartDto=new CartDto();
		BeanUtils.copyProperties(cart, cartDto);
		
		return cartDto;
		
	}
	public static Cart map(CartDto  cartDto) {
		Cart cart =new Cart();
		BeanUtils.copyProperties(cartDto, cart);
		
		return cart;
		
	}

}

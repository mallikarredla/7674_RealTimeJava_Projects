package com.javaexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.OrderItemDto;
import com.javaexpress.helper.OrderItemMappingHelper;
import com.javaexpress.model.OrderItem;
import com.javaexpress.repository.OrderItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	
	public OrderItemDto save(OrderItemDto orderItemDto) {
		log.info("OrderItemService save");
		OrderItem orderItem=OrderItemMappingHelper.map(orderItemDto);
		
		OrderItem dbOrderItem=orderItemRepository.save(orderItem);
		return OrderItemMappingHelper.map(dbOrderItem);
		
		
		
	}
	
	
	
	

}

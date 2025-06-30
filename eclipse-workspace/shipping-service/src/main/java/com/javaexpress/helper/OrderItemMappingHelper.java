package com.javaexpress.helper;

import com.javaexpress.dto.OrderItemDto;
import com.javaexpress.model.OrderItem;
import com.javaexpress.model.OrderItemId;

public class OrderItemMappingHelper {
	
	public static OrderItemDto map(OrderItem orderItem) {
		
		return OrderItemDto.builder().orderId(orderItem.getOrderItemId().getOrderId()).productId(orderItem.getOrderItemId().getProductId()).orderQuantity(orderItem.getOrderQuantity()).build();
	}
		
		
	

	
	public static OrderItem map (OrderItemDto orderItemDto) {
		OrderItemId orderItemId=new OrderItemId();
		orderItemId.setProductId(orderItemDto.getProductId());
		orderItemId.setOrderId(orderItemDto.getOrderId());
		return OrderItem.builder().orderItemId(orderItemId).orderQuantity(orderItemDto.getOrderQuantity()).build();
	}
}

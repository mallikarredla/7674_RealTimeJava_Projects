package com.javaexpress.dto;

import com.javaexpress.model.OrderItemId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderItemDto {
	
	private Integer productId;
	private Integer orderId;
	private Integer orderQuantity;
	
	
	
	

}

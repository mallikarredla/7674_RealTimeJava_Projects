package com.javaexpress.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId {
	
	
	private Integer productId;
	private Integer orderId;
	

}

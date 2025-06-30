package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.OrderItem;
import com.javaexpress.model.OrderItemId;

public interface OrderItemRepository  extends JpaRepository<OrderItem, OrderItemId>{
	
	
	
	
	

}

package com.javaexpress.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaexpress.dto.AuditLog;
import com.javaexpress.dto.OrderDto;
import com.javaexpress.feignclients.AuditFeignClient;
import com.javaexpress.helper.OrderMappingHelper;
import com.javaexpress.model.Cart;
import com.javaexpress.model.Order;
import com.javaexpress.repository.CartRepository;
import com.javaexpress.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private AuditFeignClient auditFeignClient;

	public OrderDto save(OrderDto orderDto) {
		log.info("ServiceImpl save");
		orderDto.setOrderDateTime(LocalDateTime.now());

		Cart dbCart = cartRepository.findById(orderDto.getCartDto().getCartId())
				.orElseThrow(() -> new RuntimeException("Invalid cart id"));
		Order order = OrderMappingHelper.map(orderDto);
		order.setCart(dbCart);
		Order dbOrder = orderRepository.save(order);
		AuditLog auditlog = new AuditLog("order-service", "order-created", String.valueOf(orderDto.getUserId()));
		auditFeignClient.logEvent(auditlog);
		return OrderMappingHelper.map(dbOrder);

	}

	public Optional<Order> findById(@PathVariable Integer orderId) {
		
		log.info("OrderServiceImpl findById");
		return orderRepository.findById(orderId);
	}

}

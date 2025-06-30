package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.OrderItemDto;
import com.javaexpress.service.OrderItemService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/order-items")
@RestController
@Slf4j
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	@PostMapping
	public OrderItemDto save(@RequestBody OrderItemDto orderItemDto) {
		log.info("OrderItemController");
		return orderItemService.save(orderItemDto);

	}

}

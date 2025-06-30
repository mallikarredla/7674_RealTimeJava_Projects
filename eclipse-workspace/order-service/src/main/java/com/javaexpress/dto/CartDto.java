package com.javaexpress.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.criteria.Order;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDto {
  
	
	private Integer cartId;
	private Integer userId;
	
	private List<Order> orders;


	//later will add userDto
	private UserDto userDto;
	
}

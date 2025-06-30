package com.javaexpress.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="orders")
@Data
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderId;
	
	
	private String orderDesc;
	
	private double orderFee;
	 
	private LocalDateTime orderDateTime;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	

}

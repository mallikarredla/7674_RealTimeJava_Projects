package com.javaexpress.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public enum PaymentStatus {
	
	
	NOT_STARTED,
	IN_PROGRESS,
	COMPLETED,
	FAILURE;
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private String status;
	

}

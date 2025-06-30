package com.javaexpress.model;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Embeddable
@Data

public class FavouriteId {
	
	private Integer userId;
	private Integer productId;
	private LocalDateTime likedDate;
	

}

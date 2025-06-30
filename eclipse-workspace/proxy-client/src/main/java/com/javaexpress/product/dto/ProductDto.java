package com.javaexpress.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ProductDto {
	
	private Integer productId;
	private String productTitle;
	
	private String sku;
	
	private Double priceUnit;
	
	private Integer quantity;
	
	@JsonProperty("category")
	private CategoryDto category;
}
	
	



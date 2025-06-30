package com.javaexpress.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="favourites")
@Entity
public class Favourite {
	
	@EmbeddedId
	private FavouriteId id;
	
	
	
	
	
	
	

}

package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.FavouriteDto;
import com.javaexpress.model.Favourite;
import com.javaexpress.model.FavouriteId;

public interface FavouriteHelper {
	
	public static Favourite map(FavouriteDto favouriteDto) {
		FavouriteId favouriteId=new FavouriteId();
		BeanUtils.copyProperties(favouriteDto, favouriteId);
	
		Favourite favourite =new Favourite();
		
		favourite.setId(favouriteId);
		return favourite;
		
		
	}
	public static FavouriteDto map(Favourite favourite) {
		
		
		FavouriteId favouriteId=favourite.getId();
		FavouriteDto favouriteDto=new FavouriteDto();
		BeanUtils.copyProperties(favouriteId, favouriteDto);
		return favouriteDto;
		
	}

}

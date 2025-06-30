package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.FavouriteDto;
import com.javaexpress.service.FavouriteServiceImpl;

@RestController
@RequestMapping("/api/favourites")
public class FavouriteController {
	
	  
	@Autowired
	private FavouriteServiceImpl favouriteServiceImpl;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public FavouriteDto save(@RequestBody FavouriteDto favouriteDto) {
	
	favouriteServiceImpl.save(favouriteDto);
	
	return favouriteServiceImpl.save(favouriteDto);
	
	

}
}

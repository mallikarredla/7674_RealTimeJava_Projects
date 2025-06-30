package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.Favourite;
import com.javaexpress.model.FavouriteId;

public interface FavouriteRepository  extends JpaRepository<Favourite,FavouriteId>{

}

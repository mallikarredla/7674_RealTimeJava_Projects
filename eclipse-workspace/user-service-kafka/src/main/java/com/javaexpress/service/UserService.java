package com.javaexpress.service;

import java.util.List;

import org.springframework.kafka.support.SendResult;

import com.javaexpress.dto.UserDto;

public interface UserService {

	UserDto save(UserDto userDto);

	UserDto findById(Integer UserId);

	List<UserDto> findAll();

	UserDto update(Integer userId, UserDto userDto);

	void deleteById(Integer userId);

	UserDto findByUserUserName(String userName);


}

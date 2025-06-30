package com.javaexpress.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.user.dto.UserDto;
import com.javaexpress.user.service.UserClientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/users")
@Slf4j
public class UserController {

	@Autowired
	private UserClientService userClientService;

	@PostMapping
	public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {

		log.info("UserController :save");
		return userClientService.save(userDto);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findById(@PathVariable Integer userId) {
		return userClientService.findById(userId);

	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> update(@PathVariable Integer userId, @RequestBody UserDto userDto) {
		log.info("UserController :: update");
		return userClientService.update(userId,userDto);

	}
	


}

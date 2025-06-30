package com.javaexpress.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaexpress.user.dto.UserDto;

@FeignClient(name="USER-SERVICE",contextId="UserClientService",path="/api/users",dismiss404=true)
public interface UserClientService {
	
	@PostMapping
	public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) ;
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findById(@PathVariable Integer userId) ;
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> update(@PathVariable Integer userId, @RequestBody UserDto userDto) ;
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer userId);

}

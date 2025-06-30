package com.javaexpress.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.user.dto.CredentialDto;
import com.javaexpress.user.service.CredentialClientService;

@RestController
@RequestMapping("/api/credentials")
public class CredentialController {
	
	private CredentialClientService credentialClientService;
	
	@GetMapping("username/{uname}")
	public ResponseEntity<CredentialDto>findByUserName(@PathVariable("uname") String username){
		return credentialClientService.findByUserName(username);
	}
	

}

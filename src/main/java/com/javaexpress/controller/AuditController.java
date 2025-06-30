package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.collections.AuditLog;
import com.javaexpress.service.AuditService;

@RestController
@RequestMapping("/api/audits")
public class AuditController {
	
	
	
	@Autowired
	private AuditService auditService;
	
	@PostMapping("/log")
	public ResponseEntity<String> logEvent(@RequestBody AuditLog log) {
		
		auditService.logEvent(log);
		return ResponseEntity.ok("Log Saved SuccessFully");
		
		
	}
	

}

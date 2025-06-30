package com.javaexpress.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.collections.AuditLog;
import com.javaexpress.repository.AuditLogRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuditService {
	
	
	@Autowired
	public AuditLogRepository auditLogRepository;
	
	
	public AuditLog logEvent(AuditLog log) {
		log.setTimeStamp(new Date());
		return auditLogRepository.save(log);
		
	}

}

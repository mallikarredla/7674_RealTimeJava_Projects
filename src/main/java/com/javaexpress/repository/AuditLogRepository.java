package com.javaexpress.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaexpress.collections.AuditLog;

@Repository
public interface AuditLogRepository extends MongoRepository<AuditLog,String> {
	
	
	
	

}

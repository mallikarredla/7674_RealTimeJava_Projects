package com.javaexpress.collections;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="auditlogs")
@Data
@NoArgsConstructor
public class AuditLog {
	
	private String id;
	private String serviceName;
	private String action;
	private String userId;
	private Date timeStamp;
	public AuditLog(String id, String serviceName, String action, String userId, Date timeStamp) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.action = action;
		this.userId = userId;
		this.timeStamp = new Date();
		
	}
	

}

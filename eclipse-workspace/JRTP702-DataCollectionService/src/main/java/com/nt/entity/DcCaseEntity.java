package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="DC_CASES")
@Data
public class DcCaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer caseNo;
	private Integer appId;
	private Integer planId;
	public void setAppId(Integer appId2) {
		// TODO Auto-generated method stub
		
	}
	public Integer getCaseNo() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPlanId(Object planId2) {
		// TODO Auto-generated method stub
		
	}
	public Integer getPlanId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getAppId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JRTP701_TRAVEL_PLAN")
@Data
public class TravelPlan {
	
	
	@Column(name="PLAN_ID")
	@GeneratedValue(strategy=GenerationType .AUTO)
	@Id
	private Integer planId;
	
	@Column(name="PLAN_NAME",length=30)
	private String planName;
	@Column(name="PLAN_MIN_BUDGET")
	private Double palnMinBudget;
	
	
	@Column(name="PLAN_DESCRITION",length=50)
	private String planDescription;
	@Column(name="PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name="CREATED_DATE",updatable=false)
	@CreationTimestamp		
	private LocalDateTime createdDate;
	@Column(name="UPDATED_DATE",updatable=true,insertable=false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	@Column(name="ACTIVE_SW",length=20)
	private String activeSW="active";
	
	@Column(name="CREATED_BY",length=20)
	private LocalDateTime createdBy;
	@Column(name="UPDATED_BY",length=20)
	private LocalDate updatedBy;
	
	public Object getPlanId() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setActiveSW(String status2) {
return;		
	}
	public void planName() {
		return ;
	}
	
	
}

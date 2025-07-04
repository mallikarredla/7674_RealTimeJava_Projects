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
@Table(name="PLAN_MASTER")
@Data
public class PlanEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer planId;
	@Column(length=30)
	private String planName;
	private LocalDate startDate;
	private LocalDate endDate;
	@Column(length=50)
	private String description;
	private  String activeSW;
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDateTime createDate;
	@UpdateTimestamp
	@Column(insertable=false)
	private LocalDateTime updationDate;
	@Column(length=30)
	private String createdBy;
	@Column(length=30)

	private String updatedBy;
	public String getPlanName() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

package com.nt.bindings;

import java.time.LocalDate;

import lombok.Data;


@Data
public class EligibilityDetailsOutput {
	
	
	private String holderName;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benefitAmt;
	private String denialReason;

}

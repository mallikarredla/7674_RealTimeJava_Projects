package com.nt.bindings;

import java.util.List;
import java.util.Objects;

import lombok.Data;


@Data
public class DcSummaryReport {
	
	
	private EducationInputs educationDetails;
	private List<ChildInputs> childrenDetails;
	private IncomeInputs incomeDetails;
	private CitizenAppRegistrationInputs citizenDetails;
	private String planName;
	public EducationInputs getEducationDetails() {
		return educationDetails;
	}
	public void setEducationDetails(EducationInputs educationDetails) {
		this.educationDetails = educationDetails;
	}
	public List<ChildInputs> getChildrenDetails() {
		return childrenDetails;
	}
	public void setChildrenDetails(List<ChildInputs> childrenDetails) {
		this.childrenDetails = childrenDetails;
	}
	public IncomeInputs getIncomeDetails() {
		return incomeDetails;
	}
	public void setIncomeDetails(IncomeInputs incomeDetails) {
		this.incomeDetails = incomeDetails;
	}
	public CitizenAppRegistrationInputs getCitizenDetails() {
		return citizenDetails;
	}
	public void setCitizenDetails(CitizenAppRegistrationInputs citizenDetails) {
		this.citizenDetails = citizenDetails;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(childrenDetails, citizenDetails, educationDetails, incomeDetails, planName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DcSummaryReport other = (DcSummaryReport) obj;
		return Objects.equals(childrenDetails, other.childrenDetails)
				&& Objects.equals(citizenDetails, other.citizenDetails)
				&& Objects.equals(educationDetails, other.educationDetails)
				&& Objects.equals(incomeDetails, other.incomeDetails) && Objects.equals(planName, other.planName);
	}
	@Override
	public String toString() {
		return "DcSummaryReport [educationDetails=" + educationDetails + ", childrenDetails=" + childrenDetails
				+ ", incomeDetails=" + incomeDetails + ", citizenDetails=" + citizenDetails + ", planName=" + planName
				+ "]";
	}
	

}

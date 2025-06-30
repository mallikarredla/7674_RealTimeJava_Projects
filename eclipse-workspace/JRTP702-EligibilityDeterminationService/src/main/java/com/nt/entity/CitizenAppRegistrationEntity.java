package com.nt.entity;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="CITIZEN_APPLICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenAppRegistrationEntity {
	@Id
	@SequenceGenerator(name="gen1_seq",sequenceName="app_id_seq",initialValue=1000,allocationSize=1)
	
	
	@GeneratedValue(generator="gen1_seq",strategy=GenerationType.AUTO)
	private Integer appId;
	@Column(length=30)
	private String fullname;
	@Column(length=30)
    private String email;
	@Column(length=1)
	private String gender;
	private long phoneNo;
	private long ssn;
	@Column(length=30)
	private String stateName;
	private LocalDate dob;
	@Column(length=30)
    private String createdby;
	@Column(length=30)
    private String updatedby;
	@CreationTimestamp
	private LocalDate creationDate;
	@UpdateTimestamp
	@Column(insertable=false)
    private LocalDate updationDate;
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getUpdationDate() {
		return updationDate;
	}
	public void setUpdationDate(LocalDate updationDate) {
		this.updationDate = updationDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(appId, createdby, creationDate, dob, email, fullname, gender, phoneNo, ssn, stateName,
				updatedby, updationDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CitizenAppRegistrationEntity other = (CitizenAppRegistrationEntity) obj;
		return Objects.equals(appId, other.appId) && Objects.equals(createdby, other.createdby)
				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email) && Objects.equals(fullname, other.fullname)
				&& Objects.equals(gender, other.gender) && phoneNo == other.phoneNo && ssn == other.ssn
				&& Objects.equals(stateName, other.stateName) && Objects.equals(updatedby, other.updatedby)
				&& Objects.equals(updationDate, other.updationDate);
	}
	@Override
	public String toString() {
		return "CitizenAppRegistrationEntity [appId=" + appId + ", fullname=" + fullname + ", email=" + email
				+ ", gender=" + gender + ", phoneNo=" + phoneNo + ", ssn=" + ssn + ", stateName=" + stateName + ", dob="
				+ dob + ", createdby=" + createdby + ", updatedby=" + updatedby + ", creationDate=" + creationDate
				+ ", updationDate=" + updationDate + "]";
	}
	
	
	

}

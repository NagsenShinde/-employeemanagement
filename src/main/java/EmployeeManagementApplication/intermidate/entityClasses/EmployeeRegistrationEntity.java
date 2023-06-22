package EmployeeManagementApplication.intermidate.entityClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="employee_registation")
public class EmployeeRegistrationEntity {
	
	@Id
	@Column(name ="emp_emailid")
	private String empEmailId;
	
	@Column(name ="emp_password")
	private String empPassword;
	
	@Column(name ="otp_code")
	private int  Otpcode;
	
	@Column(name ="created_on")
	private LocalDateTime CreatedOn;
	
	@Column(name ="modified_on")
	private LocalDateTime ModifiedOn;
	
	@Column(name ="otp_status")
	private boolean OtpStatus;
	
	@Column(name ="otp_starttime")
	private LocalDateTime otpStartTime;
	
	
	@Value("${otp.expiration.minutes}")
	@Column(name ="otp_expiretime")	
	private LocalDateTime otpExpireTime;

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public int getOtpcode() {
		return Otpcode;
	}

	public void setOtpcode(int i) {
		Otpcode = i;
	}

	public LocalDateTime getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		CreatedOn = createdOn;
	}

	public LocalDateTime getModifiedOn() {
		return ModifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		ModifiedOn = modifiedOn;
	}

	public boolean getOtpStatus() {
		return OtpStatus;
	}

	public void setOtpStatus(boolean otpStatus) {
		OtpStatus = otpStatus;
	}

	public LocalDateTime getOtpStartTime() {
		return otpStartTime;
	}

	public void setOtpStartTime(LocalDateTime otpStartTime) {
		this.otpStartTime = otpStartTime;
	}


	public LocalDateTime getOtpExpireTime() {
		return otpExpireTime;
	}

	public void setOtpExpireTime(LocalDateTime otpExpireTime) {
		this.otpExpireTime = otpExpireTime;
	}

	@Override
	public String toString() {
		return "EmployeeRegistrationEntity [empEmailId=" + empEmailId + ", empPassword=" + empPassword + ", Otpcode="
				+ Otpcode + ", CreatedOn=" + CreatedOn + ", ModifiedOn=" + ModifiedOn + ", OtpStatus=" + OtpStatus
				+ ", otpStartTime=" + otpStartTime + ", otpExpireTime=" + otpExpireTime + "]";
	}

 

}

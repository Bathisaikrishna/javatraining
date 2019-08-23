package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@DiscriminatorValue("creditcard")
public class OnlineDonation extends Donation {

	private String ccType;
	private String ccNo;
	
	@JsonFormat(pattern = "dd-mm-yyyy hh:mm")
	private Date ccExpDate;
	private String ccCode;
	public String getCcType() {
		return ccType;
	}
	public void setCcType(String ccType) {
		this.ccType = ccType;
	}
	public String getCcNo() {
		return ccNo;
	}
	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}
	public Date getCcExpDate() {
		return ccExpDate;
	}
	public void setCcExpDate(Date ccExpDate) {
		this.ccExpDate = ccExpDate;
	}
	public String getCcCode() {
		return ccCode;
	}
	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}

}

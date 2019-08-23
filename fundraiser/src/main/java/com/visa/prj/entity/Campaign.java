package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="campaigns")
public class Campaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	private String title;
	
	private String description;
	
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm")
	private Date deadline;
	
	private double donated_amount;
	
	private double target_amount;
	
	private String terms;
	
	private String status;

	public double getDonated_amount() {
		return donated_amount;
	}

	public void setDonated_amount(double donated_amount) {
		this.donated_amount = donated_amount;
	}

	public double getTarget_amount() {
		return target_amount;
	}

	public void setTarget_amount(double target_amount) {
		this.target_amount = target_amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	
	
	
	
}

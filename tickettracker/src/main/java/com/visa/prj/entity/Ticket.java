package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticket_id;
	
	private String ticket_desc;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date raised_date = new Date();
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="raised_by")
	private Employee raised_by;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="resolved_by")
	private Employee resolved_by = null;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date resolved_date = null;
	
	private String resolved_text = null;

	public void setRaised_by(Employee raised_by) {
		this.raised_by = raised_by;
	}

	public void setResolved_by(Employee resolved_by) {
		this.resolved_by = resolved_by;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getTicket_desc() {
		return ticket_desc;
	}

	public void setTicket_desc(String ticket_desc) {
		this.ticket_desc = ticket_desc;
	}

	public Date getRaised_date() {
		return raised_date;
	}

	public void setRaised_date(Date raised_date) {
		this.raised_date = raised_date;
	}


	public Date getResolved_date() {
		return resolved_date;
	}

	public void setResolved_date(Date resolved_date) {
		this.resolved_date = resolved_date;
	}

	public String getResolved_text() {
		return resolved_text;
	}

	public void setResolved_text(String resolved_text) {
		this.resolved_text = resolved_text;
	}

	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", ticket_desc=" + ticket_desc + ", raised_date=" + raised_date
				+ ", raised_by=" + raised_by + ", resolved_by=" + resolved_by + ", resolved_date=" + resolved_date
				+ ", resolved_text=" + resolved_text + "]";
	}
	
	
	
	
	
}

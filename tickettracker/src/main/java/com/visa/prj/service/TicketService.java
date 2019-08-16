package com.visa.prj.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.dao.ITEmployeeDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService{
	
	@Autowired
	@Qualifier("employee")
	private EmployeeDao employeeDao;
	
	@Autowired
	@Qualifier("itemployee")
	private ITEmployeeDao itemployeeDao;
	
	
	
	@Transactional
	public long raiseTicket(String emp_raised, String desc, Date raiseDate) {
		
		Ticket t = new Ticket();
		t.setTicket_desc(desc);
		t.setRaised_date(raiseDate);
		t.setRaised_by(employeeDao.getEmployee(emp_raised));
		
		employeeDao.raiseTicket(t);
		
		return 0;
	}
	
	public List<Ticket> getOpenTickets(){
		return itemployeeDao.getOpenTickets();
	}

	@Transactional 
	public void resolveTicket(Ticket ticket,Employee resolvedEmp) {
		itemployeeDao.resolveTicket(ticket, resolvedEmp);
		
	}
	
	public Employee getEmp(String email)
	{
		return employeeDao.getEmployee(email);
	}
	
}

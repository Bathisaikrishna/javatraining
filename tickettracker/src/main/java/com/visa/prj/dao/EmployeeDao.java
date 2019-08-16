package com.visa.prj.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Repository
public interface EmployeeDao {

	long calculateTAT(Date start, Date end);
	long raiseTicket(Ticket t);
	Employee getEmployee(String mail);
}

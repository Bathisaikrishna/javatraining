package com.visa.prj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Repository
public interface ITEmployeeDao extends EmployeeDao {

	List<Ticket> getOpenTickets();
	void resolveTicket(Ticket t,Employee resolved_emp);
}

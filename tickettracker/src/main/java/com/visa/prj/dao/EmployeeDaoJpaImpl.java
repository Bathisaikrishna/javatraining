package com.visa.prj.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Repository
@Qualifier("employee")
public class EmployeeDaoJpaImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public long raiseTicket(Ticket t) {
		em.persist(t);
		return 0;
		

	}
	@Override
	public Employee getEmployee(String mail) {
		Employee obj = em.find(Employee.class, mail);
		return obj;
	}
	@Override
	public long calculateTAT(Date start, Date end) {
		
		return 0;
	}
	

}

package com.visa.prj.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Repository
@Qualifier("itemployee")
public class ITEmployeeDaoJpaImpl implements ITEmployeeDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public long raiseTicket(Ticket t) {
		em.persist(t);
		return 0;
	}

	@Override
	public List<Ticket> getOpenTickets() {
		
		String jpql = "from Ticket t where t.resolved_by is null";
		TypedQuery<Ticket> openTicketsQuery = em.createQuery(jpql, Ticket.class);
		
		return openTicketsQuery.getResultList();
	}


	@Override
	public void resolveTicket(Ticket t, Employee resolved_emp) {
		
		if(resolved_emp.getDept().equalsIgnoreCase("IT")) {
			t.setResolved_by(resolved_emp);
			t.setResolved_date(new Date());
			t.setResolved_text(t.getTicket_desc() + "overcomed!!!");
			em.merge(t);
		}
	}

	@Override
	public Employee getEmployee(String mail) {
		Employee obj = em.find(Employee.class, mail);
		return obj;
		
	}

	@Override
	public long calculateTAT(Date start, Date end) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

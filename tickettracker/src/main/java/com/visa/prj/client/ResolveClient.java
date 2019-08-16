package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Ticket;
import com.visa.prj.service.TicketService;

public class ResolveClient {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		TicketService ts = ctx.getBean("ticketService", TicketService.class);
		List<Ticket> openTickets= ts.getOpenTickets();
		for (Ticket ticket : openTickets) {
			System.out.println(ticket);
			ts.resolveTicket(ticket, ts.getEmp("b@visa.com"));
		}
		
		
		
		
	}

}

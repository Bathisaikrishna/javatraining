package com.visa.prj.client;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Employee;
import com.visa.prj.service.TicketService;

public class TicketClient {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		TicketService ts = ctx.getBean("ticketService", TicketService.class);
		
		long tick_id = ts.raiseTicket("a@visa.com", "Laptop reboot", new Date());
		if(tick_id == 0)
		System.out.println("Generated ticket!!!");
		
		
	}

}

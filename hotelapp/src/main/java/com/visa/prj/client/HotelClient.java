package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.service.BookingService;



public class HotelClient {

	public static void main(String[] args) {
		//to create spring container annotation - based
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		BookingService bs = ctx.getBean("bookingService", BookingService.class);
		
		System.out.println(bs.getHotelById(1));
	
		System.out.println(bs.getUser("bdoddi@visa.com", "BathiSaiKrishna"));
		
		
		
		
		
		

	}

}

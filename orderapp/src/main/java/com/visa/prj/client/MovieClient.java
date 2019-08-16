package com.visa.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.dao.MovieDao;
import com.visa.prj.entity.Actor;
import com.visa.prj.entity.Movie;

public class MovieClient {

	public static void main(String[] args) {
		//to create spring container annotation - based
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		MovieDao dao = ctx.getBean("movieDao", MovieDao.class);
		
		Movie m = new Movie();
		
		m.setName("Indra");
		
		Actor a1 = new Actor();
		a1.setAname("Chiranjeevi");
		
		Actor  a2 = new Actor();
		a2.setAname("Aarthi agarwal");
		
		m.getActors().add(a1);
		m.getActors().add(a2);
		
		dao.addMovie(m);
		
		System.out.println("Saved!!!");
		

}
}

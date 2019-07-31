package com.visa.prj.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	@Test
	public void testAddtime() {
		Time t1 = new Time(4,30);
		Time t2 = new Time(3,45);
		assertEquals(new Time(8,15),Time.addtime(t1, t2));
		
	}

	@Test
	public void testAddTime() {
		Time t1 = new Time(4,30);
		Time t2 = new Time(3,45);
		
		assertEquals(new Time(8,15),t1.addTime(t2));
	}

}

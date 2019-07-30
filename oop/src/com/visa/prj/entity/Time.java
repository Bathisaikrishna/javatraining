package com.visa.prj.entity;

public class Time {

	private int hours;
	private int minutes;
	
	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public static Time addtime(Time t1, Time t2) {
		int newHours = t1.getHours() + t2.getHours() + ((t1.getMinutes() + t2.getMinutes())/60);
		int newMin = (t1.getMinutes() + t2.getMinutes())%60;
		
		Time newTime = new Time(newHours,newMin);
		return newTime;
		
	}

	public Time addTime(Time t2) {
		
		int newHours = this.getHours() + t2.getHours() + ((this.getMinutes() + t2.getMinutes())/60);
		int newMin = (this.getMinutes() + t2.getMinutes())%60;
		
		Time newTime = new Time(newHours,newMin);
		return newTime;
	}
	
}

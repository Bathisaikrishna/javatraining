package com.visa.prj.entity;

public class DataTransferObject {
String name;
double price;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public DataTransferObject(String name, double price) {
	this.name = name;
	this.price = price;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+this.name+" "+"Price: "+this.price;
	}
}

package com.visa.prj.entity;

public abstract class Product implements Comparable<Product> {
	
	public Product() {
	}
	private int id;
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	private String name;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	
	public abstract boolean isExpensive();
	
	@Override
	public int compareTo(Product o) {
		return Double.compare(this.price, o.price);
	}
	@Override
	public String toString() {
		
		return "Product [id =" + this.id + " ]";
	}
	
}

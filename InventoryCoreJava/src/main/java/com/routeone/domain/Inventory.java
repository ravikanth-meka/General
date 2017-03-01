package com.routeone.domain;

public class Inventory {

	private String component;
	private double price;
	private String category;
	
	
	
	public Inventory(String component, double price, String category) {
		super();
		this.component = component;
		this.price = price;
		this.category = category;
	}
	
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}

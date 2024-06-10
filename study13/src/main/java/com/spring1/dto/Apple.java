package com.spring1.dto;

public class Apple implements Fruits {
	private int price;
	public Apple() {}
	public Apple(int price) {
		super();
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Apple [price=" + price + "]";
	}
	
}

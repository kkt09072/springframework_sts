package com.spring1.dto;

public class Kiwi implements Fruits {
	private int price;
	public Kiwi() { } 
	public Kiwi(int price) {
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
		return "Kiwi [price=" + price + "]";
	}
}

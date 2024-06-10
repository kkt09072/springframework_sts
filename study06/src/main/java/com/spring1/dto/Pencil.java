package com.spring1.dto;

public class Pencil implements Product {
	private String proName;
	private int price;
	public Pencil() { }
	public Pencil(String proName, int price) {
		super();
		this.proName = proName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Pencil [proName=" + proName + ", price=" + price + "]";
	}
}

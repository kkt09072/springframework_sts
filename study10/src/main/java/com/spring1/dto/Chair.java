package com.spring1.dto;

public class Chair implements Goods {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Chair [price=" + price + "]";
	}
	
}

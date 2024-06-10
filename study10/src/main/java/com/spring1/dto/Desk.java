package com.spring1.dto;

public class Desk implements Goods {
	private double size;

	public Desk(double size) {
		super();
		this.size = size;
	}

	@Override
	public String toString() {
		return "Desk [size=" + size + "]";
	}
	
}

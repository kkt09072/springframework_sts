package com.spring1.dto;

public class Mango implements Fruits{
	private int size;
	public Mango() {}
	public Mango(int size) {
		super();
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Mango [size=" + size + "]";
	}
}

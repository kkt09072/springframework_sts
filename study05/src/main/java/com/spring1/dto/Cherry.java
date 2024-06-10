package com.spring1.dto;

public class Cherry implements Fruits{
	private double amount;
	public Cherry() { }
	public Cherry(double amount) {
		super();
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Cherry [amount=" + amount + "]";
	}
	
}

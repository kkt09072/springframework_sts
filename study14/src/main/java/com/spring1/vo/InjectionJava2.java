package com.spring1.vo;
public class InjectionJava2 {
	private int data1;
	private double data2;
	private String data3;
	public InjectionJava2(int data1) {
		this.data1 = data1;
		this.data2 = 0.0;
		this.data3 = null;
	}
	public InjectionJava2(double data2) {
		this.data1 = 0;
		this.data2 = data2;
		this.data3 = null;
	}
	public InjectionJava2(String data3) {
		this.data1 = 0;
		this.data2 = 0.0;
		this.data3 = data3;
	}
}

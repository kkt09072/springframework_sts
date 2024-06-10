package com.spring1.test;

import com.spring1.dto.Market;

public class InjectionAnnotation3 {
	private int data1;
	private String data2;
	private Market marketBean1;
	public InjectionAnnotation3(int data1, String data2, Market marketBean1) {
		super();
		this.data1 = data1;
		this.data2 = data2;
		this.marketBean1 = marketBean1;
	}
	public int getData1() {
		return data1;
	}
	public void setData1(int data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public Market getMarketBean1() {
		return marketBean1;
	}
	public void setMarketBean1(Market marketBean1) {
		this.marketBean1 = marketBean1;
	}
}

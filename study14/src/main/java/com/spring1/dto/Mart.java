package com.spring1.dto;

import java.util.Set;

public class Mart {
	private String martName;
	private Set<Fruits> fr;
	public Mart() { }
	public Mart(String martName, Set<Fruits> fr) {
		super();
		this.martName = martName;
		this.fr = fr;
	}
	public String getMartName() {
		return martName;
	}
	public void setMartName(String martName) {
		this.martName = martName;
	}
	public Set<Fruits> getFr() {
		return fr;
	}
	public void setFr(Set<Fruits> fr) {
		this.fr = fr;
	}
	@Override
	public String toString() {
		return "Mart [martName=" + martName + ", frSet=" + fr + "]";
	}
	
}

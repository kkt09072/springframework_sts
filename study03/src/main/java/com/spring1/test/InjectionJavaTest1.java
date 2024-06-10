package com.spring1.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.dto.Store;
import com.spring1.vo.InjectionJava1;

@Service
public class InjectionJavaTest1 {

	private InjectionJava1 injectionJava1;	//필드 주입

	//생성자(Constructor)로 주입
	@Autowired
	public InjectionJavaTest1(InjectionJava1 injectionJava1) {
		this.injectionJava1 = injectionJava1;
	}

	//수정자(setter) 주입
	@Autowired
	public void setInjectionJava1(InjectionJava1 injectionJava1) {
		this.injectionJava1 = injectionJava1;
	}

	public Store getStore() {
		return injectionJava1.getStore();
	}	
}

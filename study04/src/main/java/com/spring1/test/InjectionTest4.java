package com.spring1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring1.dto.Mart;

public class InjectionTest4 {
	public static void main(String[] args) {
		ApplicationContext ctx4 = new GenericXmlApplicationContext("classpath:injectionContext4.xml");
		
		Mart mart1 = ctx4.getBean("mart1", Mart.class);
		System.out.println(mart1);
	}
}

package com.spring1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring1.dto.Market;

public class InjectionTest3 {

	public static void main(String[] args) {
		ApplicationContext ctx3 = new GenericXmlApplicationContext("classpath:injectionContext3.xml");
		
		Market market1 = ctx3.getBean("market1", Market.class);
		System.out.println(market1);
	}

}

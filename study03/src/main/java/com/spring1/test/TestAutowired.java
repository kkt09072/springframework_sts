package com.spring1.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring1.dao.SampleDAO;
import com.spring1.dao.SampleDAOImpl;

public class TestAutowired {
	
	@Autowired
	private SampleDAO sampleDAO;

	public TestAutowired() {
		this.sampleDAO = new SampleDAOImpl();
	}
}

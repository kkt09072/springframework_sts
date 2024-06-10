package com.spring1.test;

import javax.inject.Inject;

import com.spring1.dao.SampleDAO;
import com.spring1.dao.SampleDAOImpl;

public class TestInject {

	@Inject
	private SampleDAO sampleDAO; 
	
	public TestInject() {
		this.sampleDAO = new SampleDAOImpl();
	}
}

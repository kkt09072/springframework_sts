package com.spring1.test;

import javax.annotation.Resource;

import com.spring1.dao.SampleDAO;
import com.spring1.dao.SampleDAOImpl;

public class TestResource {
	
	@Resource(name="testDAO")
	private SampleDAO sampleDAO;
	
	public TestResource() {
		this.sampleDAO = new SampleDAOImpl();
	}
}

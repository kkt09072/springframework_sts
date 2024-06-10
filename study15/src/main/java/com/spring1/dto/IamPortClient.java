package com.spring1.dto;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IamPortClient {
	public final static String CODE = "imp45671068";
	public final static String KEY = "6155752234118080";
	public final static String SECRET = "";

	private String randChar;

	public IamPortClient() {
		Date date = new Date();
		this.randChar =  date + RandomStringUtils.randomAlphanumeric(12);
	}
	
}

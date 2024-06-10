package com.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Custom {
	private String id;  
	private String pw; 
	private String name;  
	private String email; 
	private String tel;  
	private String addr; 
	private String postcode; 
	private String regdate;
}

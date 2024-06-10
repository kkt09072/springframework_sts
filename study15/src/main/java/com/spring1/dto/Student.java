package com.spring1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@JsonProperty("stdNumber")
    private int stdNumber;
	
	@JsonProperty("name")
    private String name;

	@JsonProperty("age")	
    private int age;
}

package com.spring1.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok을 활용한 DTO

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Check {
	private String id;
	private String pw;
}

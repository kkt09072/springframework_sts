package com.spring1.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UploadData {
	private String name;
	private Long size; 
	private String uuidName;
	
	public UploadData(String name, Long size) {
		this.name = name;
		this.size = size;
	}
}

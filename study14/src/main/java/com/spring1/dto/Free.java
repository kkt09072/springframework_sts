package com.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Free {
	private int no;
	private String title;
	private String content;
	private int hits;
	private String resdate;
	private String id;
	private String name;
}

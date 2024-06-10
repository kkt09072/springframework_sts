package com.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int bno;
	private String title;
	private String content;
	private String author;
	private int vcnt;
	private String resdate;
}

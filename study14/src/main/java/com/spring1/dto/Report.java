package com.spring1.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Report implements Serializable{
	int no;
	int contentId;
	String contentCategory;
	String reporter;
	String reportedMember;
	int category;
	Date reportedDate;
	String validYN;
	
}

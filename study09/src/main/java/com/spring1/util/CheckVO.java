package com.spring1.util;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//javax.validation + Lombok 을 활용한 검증 VO

@NoArgsConstructor
@AllArgsConstructor
public class CheckVO {
	
	@Id
	@Size(min=5, max=12, message="아이디는 5~12 자로 작성해야 합니다.")
	@Pattern(regexp="^[a-z0-9]+$", message="영문 소문자와 숫자로만 입력해야 합니다.")
	String id;
	
	
	@NotNull
	@Size(min=8, max=12, message="비밀번호는 8~12 자로 작성해야 합니다.")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="영문 대소문자와 숫자로만 입력해야 합니다.")
	String pw;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	@Override
	public String toString() {
		return "CheckVO [id=" + id + ", pw=" + pw + "]";
	}
	
}

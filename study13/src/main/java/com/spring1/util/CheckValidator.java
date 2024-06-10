package com.spring1.util;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//springframework validation을 활용한 VO(DTO) 검증

@Component
public class CheckValidator implements Validator {

	private static final Logger log = LoggerFactory.getLogger(CheckValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Check.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		log.info("springframework validation");
		
		Check check = (Check) obj;
		ValidationUtils.rejectIfEmpty(errors, "id", "check.id.empty", "아이디를 입력해주세요");
		ValidationUtils.rejectIfEmpty(errors, "pw", "check.pw.empty", "비밀번호를 입력해주세요");
		
		//아이디 입력 패턴
		Pattern pat1 = Pattern.compile("^[a-z0-9]{5,12}$", Pattern.CASE_INSENSITIVE);
		//비밀번호 입력 패턴
		Pattern pat2 = Pattern.compile("^[a-zA-Z0-9]{8,12}$", Pattern.CASE_INSENSITIVE);
		if(!(pat1.matcher(check.getId()).matches())) {
			errors.rejectValue("id", "check.id.invaild");
		}
		if(!(pat2.matcher(check.getPw()).matches())) {
			errors.rejectValue("pw", "check.pw.invaild");
		}
		
	}

	
}

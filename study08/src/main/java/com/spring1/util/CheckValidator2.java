package com.spring1.util;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CheckValidator2 implements Validator {
	private static final Logger log = LoggerFactory.getLogger(CheckValidator2.class);
	
    public void validate(Object obj, Errors error) {
        System.out.println("validate action");
        CheckVO check = (CheckVO)obj;

        Pattern pat1 = Pattern.compile("^[a-z0-9]$", Pattern.CASE_INSENSITIVE);
        Pattern pat2 = Pattern.compile("^[a-zA-Z0-9]$", Pattern.CASE_INSENSITIVE);

        if(!(pat1.matcher(check.getId()).matches())){
            error.rejectValue("id", "check.id.invalid", "아이디 형식이 일치하지 않습니다.");
        }
        if(!(pat2.matcher(check.getPw()).matches())){
            error.rejectValue("pw", "check.pw.invalid", "비밀번호 형식이 올바르지 않습니다.");
        }

	    String id = check.getId();
        String pw = check.getPw();

        if(id == null || id.trim().isEmpty()) {
            error.rejectValue("id", "not value");
        }

        if(pw == null || pw.trim().isEmpty()) {
            error.rejectValue("pw", "not value");
        }

        //id가 8~12 이하인지 확인
        if(id.length() < 5 || id.length() > 12) {
            error.rejectValue("id", "id bad size", "아이디의 글자수가 맞지 않습니다.");
        }

        //pw가 6~12자 이하인지 확인
        if(pw.length() < 8 || pw.length() > 12) {
            error.rejectValue("pw", "pw bad size", "비밀번호의 글자수가 맞지 않습니다.");
        }

    }
	
    @Override
    public boolean supports(Class<?> clazz) {
        return CheckVO.class.isAssignableFrom(clazz);
    }
}

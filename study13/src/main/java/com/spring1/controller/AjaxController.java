package com.spring1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring1.dto.Sample;
import com.spring1.dto.Student;
import com.spring1.service.SampleService;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	private static final Logger log = 
			LoggerFactory.getLogger(AjaxController.class);
	
    @Autowired
    private SampleService sampleService;
	
	@GetMapping("/")	
	public String ajaxHome() {
		return "ajax/home";
	}
	
    @GetMapping("/ajax1.do")
    public String ajaxTest1() { return "ajax/ajax1"; }

    @ResponseBody
    @GetMapping(value="/ajax1pro.do", produces="application/json;charset=UTF-8")
    public String ajaxTest1Pro() {
    	String str = "GET 전송 테스트";
    	log.info(str);
        return str;
    }

    @GetMapping("/ajax2.do")
    public String ajaxTest2() { return "/ajax/ajax2"; }

    @PostMapping("/ajax2pro.do")
    public String ajaxTest2Pro() {
    	String str = "POST 전송 테스트";
        log.info(str);
        return "ajax/ajax2";
    }

    @GetMapping("/ajax3")
    public String ajaxTest3() {
        return "ajax/ajax3";
    }

    @GetMapping("/ajax3pro.do")
    public String ajaxTest3Pro(@RequestParam("msg") String msg) {
        log.info(msg);
        return "ajax/ajax3";
    }

    @GetMapping("/ajax4.do")
    public String ajaxTest4() {
        return "ajax/ajax4";
    }

    @PostMapping("/ajax4pro.do")
    public String ajaxTest4Pro(@RequestParam("msg") String msg) {
        log.info(msg);
        return "/ajax/ajax4";
    }

    @GetMapping("/ajax5.do")
    public String ajaxTest5() {
        return "ajax/ajax5";
    }

    @GetMapping("/ajax5pro.do")
    @ResponseBody
    public Student ajaxTest5Pro(@ModelAttribute("student") Student student) {
        log.info(student.toString());
        return student;
    }

    @GetMapping("/ajax6.do")
    public String ajaxTest6() {
        return "ajax/ajax6";
    }

    @PostMapping("/ajax6pro")
    @ResponseBody
    public Student ajaxTest6Pro(@ModelAttribute("student") Student student) {
        log.info(student.toString());
        return student;
    }

    @GetMapping("/ajax7.do")
    public String ajaxTest7() {
        return "ajax/ajax7";
    }
    
    @PostMapping("/ajax7pro.do")
    @ResponseBody
    public Student ajaxTest7Pro(@RequestBody Student student) {
        log.info(student.toString());
        return student;
    }

    @GetMapping("/ajax8.do")
    public String ajaxTest8() {
        return "ajax/ajax8";
    }
    
    @PostMapping("/ajax8pro.do")
    @ResponseBody
    public List<Sample> ajaxTest8Pro(@RequestBody Sample sample) throws Exception {
        log.info(sample.toString());
        sample.setNum(sampleService.maxNum());
        sampleService.insSample(sample);
        List<Sample> tList = sampleService.getSampleList();
        return tList;
    }

    @GetMapping("/ajax9.do")
    public String ajaxTest9() {
        return "ajax/ajax9";
    }

    @PostMapping(value="/ajax9pro.do", produces="application/json;charset=UTF-8")
    public ResponseEntity ajaxTest9Pro(@RequestBody Sample sample) throws Exception {
        log.info(sample.toString());
        return new ResponseEntity<>(sample, HttpStatus.OK);
    }

    @GetMapping("/ajax10.do")
    public String ajaxTest10() {
        return "ajax/ajax10";
    }

    @PostMapping(value="/ajax10pro.do", produces="application/json;charset=UTF-8")
    public ResponseEntity ajaxTest10Pro(@RequestBody Sample sample) throws Exception {
    	sample.setNum(sampleService.maxNum());
    	sampleService.insSample(sample);
        List<Sample> tList = sampleService.getSampleList();
        return new ResponseEntity<>(tList, HttpStatus.OK);
    }
}

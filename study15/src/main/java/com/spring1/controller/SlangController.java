package com.spring1.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring1.interceptor.ProfanityFilterInterceptor;

@Controller
@RequestMapping("/slang/")
public class SlangController {
	
	private final static Logger log = LoggerFactory.getLogger(SlangController.class);
	
	@Autowired
	private ProfanityFilterInterceptor proFilter;
	
	@GetMapping("form")
	public String loadingForm(Model model) {
		return "slang/form";
	}
	
    @RequestMapping(value = "submitContent", method = RequestMethod.POST)
    public ModelAndView submitContent(@RequestParam("content") String content) {
        ModelAndView modelAndView = new ModelAndView();
        
        // 여기서 content를 ProfanityFilterInterceptor에 전달하여 필터링
        boolean pass = proFilter.containsProfanity(content);
        
        String data = content;
        
        if(pass) {
        	data = "콘텐츠에 부적절한 언어가 포함되어 있습니다";
        }
        
        modelAndView.addObject("filteredContent", data); // 필터링된 content를 JSP에 전달
        modelAndView.setViewName("slang/filteredContent"); // 필터링된 content를 보여줄 JSP 페이지 지정
        
        return modelAndView;
    }
    
	@GetMapping("form2")
	public String ajaxForm(Model model) {
		return "slang/ajaxForm";
	}
    
    @PostMapping("submitContent2")
    @ResponseBody
    public ResponseEntity<Map<String, String>> submitContent2(@RequestBody String content) {
        
    	log.info("content :{}", content);
    	
        // 여기서 content를 ProfanityFilterInterceptor에 전달하여 필터링
        boolean pass = proFilter.containsProfanity(content);
        
        String filteredContent = "";
        
        if(pass) {
        	filteredContent = "콘텐츠에 부적절한 언어가 포함되어 있습니다";
        } else {
        	filteredContent = content;
        }
        
        Map<String, String> response = new HashMap<>();
        response.put("filteredContent", filteredContent);
        
        // JSON 형태로 응답
        return ResponseEntity.ok(response);
    }
    
    
}

package com.spring1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring1.util.TestException;

@Controller
@RequestMapping("/error/")
public class ErrorController {

    @GetMapping("death")
    public Model getBoardListView(Model model) throws Exception {
        throw new TestException();
    }
	
    @ExceptionHandler(TestException.class)
    public ModelAndView testExceptionHandler(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.setStatus(HttpStatus.BAD_REQUEST);
        mv.setViewName("error/errorException");
        return mv;
    }
	
    @ExceptionHandler(TestException.class)
    public ModelAndView testExceptionHandler2(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.setStatus(HttpStatus.BAD_REQUEST);
        mv.setViewName("error/errorException");
        return mv;
    }
    
	@GetMapping("message.do")
	public String getMain(Model model) {
		return "error/message";
	}
}

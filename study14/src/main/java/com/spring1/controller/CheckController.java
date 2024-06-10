package com.spring1.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring1.util.BindExceptionWithViewName;
import com.spring1.util.Check;
import com.spring1.util.CheckVO;
import com.spring1.util.CheckValidator;
import com.spring1.util.CheckValidator2;

@Controller
@RequestMapping("/check")
public class CheckController {

	//private CheckVO chk1;
	
	@Autowired
	private CheckValidator check;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/")
	public String checkHome(Model model) {
		return "check/home";
	}
	
	@GetMapping("/check1.do")
	public String check1(Model model) {
		return "check/check1";
	}
	
	@PostMapping("/check1pro.do")
	public String check1pro(@RequestParam String id, @RequestParam String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "check/check1_result";
	}
	
	@GetMapping("/check2.do")
	public String check2(Model model) {
		return "check/check2";
	}
	
	@PostMapping("/check2pro.do")
	public String check2pro(@RequestParam String id, @RequestParam String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "check/check2_result";
	}
	
	@GetMapping("/check3.do")
	public String check3(Model model) {
		return "check/check3";
	}
	
	@GetMapping("/check3pro.do")
	public String check3pro(@RequestParam String id, @RequestParam String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "check/check3_result";
	}
	
	@GetMapping("/check4.do")
	public String check4(Model model) {
		return "check/check4";
	}
	
	@PostMapping("/check4pro.do")
	public String check4pro(@ModelAttribute("check") Check check, Model model, BindingResult result) {
		String page = "check/check4_result";
		CheckValidator ckVal = new CheckValidator();
		ckVal.validate(check, result);
		if(result.hasErrors()) {
			page = "check/error4";
		} else {
			model.addAttribute("id", check.getId());
			model.addAttribute("pw", check.getPw());
		}
		return page;
	}
	
	@InitBinder("check")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new CheckValidator());
	}
	
	@InitBinder("chk1")
	protected void initBinder2(WebDataBinder binder) {
		binder.setValidator(new CheckValidator2());
	}

	@GetMapping("/check5.do")
	public String check5(Model model) {
        model.addAttribute("check", new Check());
        return "check/check5";
	}
	
    @PostMapping("/check5pro.do")
    public String check5pro(@Valid @ModelAttribute("check") Check check, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "check/error5";
        }
        model.addAttribute("check", check);
        return "check/check5_result";
    }
	
	@GetMapping("/check6.do")
	public String check6(Model model, @ModelAttribute("chk1") CheckVO chk1) {
		model.addAttribute("chk1", chk1);
		return "check/check6";
	}
		
    @PostMapping("/check6.do")
    public String check6pro(@Valid @ModelAttribute("chk1") CheckVO chk1, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "check/check6";
        }
        model.addAttribute("chk1", chk1);
        return "check/check6_result";
    }
}

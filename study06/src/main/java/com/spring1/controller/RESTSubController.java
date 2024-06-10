package com.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/sub/")
public class RESTSubController {

	@GetMapping("api5")
	public String api5() {
		return "api/api5";
	}
	
	@GetMapping("api6")
	public String api6() {
		return "api/api6";
	}
	
	@GetMapping("api7")
	public String api7() {
		return "api/api7";
	}
	
	@GetMapping("api8")
	public String api8() {
		return "api/api8";
	}
	
	@GetMapping("api9")
	public String api9() {
		return "api/api9";
	}
	
	@GetMapping("api10")
	public String api10() {
		return "api/api10";
	}
	
	@GetMapping("api11")
	public String api11() {
		return "api/api11";
	}
	
	@GetMapping("api12")
	public String api12() {
		return "api/api12";
	}
	
	@GetMapping("api13")
	public String api13() {
		return "api/api13";
	}
	
	@GetMapping("api14")
	public String api14() {
		return "api/api14";
	}
	
	@GetMapping("api15")
	public String api15() {
		return "api/api15";
	}
}

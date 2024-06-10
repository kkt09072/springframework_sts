package com.spring1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring1.dto.Custom;
import com.spring1.service.CustomService;

@Controller
@RequestMapping("/custom/")
public class CustomController {

	@Autowired
	private CustomService customService;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private HttpSession session;

	@GetMapping("agree.do")
	public String agree(Model model, RedirectAttributes rttr) {
		rttr.addAttribute("msg", "회원 약관에 동의하시기 바랍니다.");
		return "custom/agree";
	}
	
	@GetMapping("join.do")
	public String join(Model model, @ModelAttribute("custom") Custom custom) {
		model.addAttribute("custom", custom);
		return "custom/join";
	}

	@PostMapping("idCheck.do")
	public void idCheck(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		String id = request.getParameter("id");
		Custom cus = customService.getCustom(id);
		boolean result;
		if(cus!=null) {
			result = false;
		} else {
			result = true;
		}
		JSONObject json = new JSONObject();
		json.put("result", result);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}
	
	@PostMapping("joinPro.do")
	public String joinPro(HttpServletRequest request, Model model, RedirectAttributes rttr) {
		Custom custom = new Custom();
		custom.setId(request.getParameter("id"));
		custom.setPw(pwdEncoder.encode(request.getParameter("pw")));	//비밀번호 암호화
		custom.setName(request.getParameter("name"));
		custom.setEmail(request.getParameter("email"));
		custom.setTel(request.getParameter("tel"));
		custom.setAddr(request.getParameter("addr1") + " $ " +request.getParameter("addr2"));
		custom.setPostcode(request.getParameter("postcode"));
		customService.insCustom(custom);
		model.addAttribute("msg", "회원가입을 축하합니다.");
		return "redirect:/";
	}
	
	@GetMapping("login.do")
	public String login(Model model) {
		return "custom/login";
	}

	@PostMapping("loginPro.do")
	public String loginPro(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model, RedirectAttributes rttr) {
		session.invalidate();
		Custom cus = customService.getCustom(id);
		boolean loginSuccess = pwdEncoder.matches(pw, cus.getPw());
		if(loginSuccess) {
			session.setAttribute("cus", cus);
			session.setAttribute("sid", id);
			session.setAttribute("spw", pw);
			model.addAttribute("msg", "로그인 성공");
			return "redirect:/";
		} else {
			//rttr.addAttribute("msg", "로그인 실패");
			return "redirect:login.do";	
		}
	}
	
	@GetMapping("logout.do")
	public String logout(Model model, RedirectAttributes rttr) {
		session.invalidate();
		model.addAttribute("msg", "로그아웃 하였습니다.");
		return "redirect:/";
	}
	
	@GetMapping("myInfo.do")
	public String myInfo(Model model) {
		return "custom/myInfo";
	}
	
	@GetMapping("myUpdate.do")
	public String myUpdate(Model model) {
		return "custom/myUpdate";
	}
	
	
	@PostMapping("myUpdatePro.do")
	public String myUpdatePro(HttpServletRequest request, Model model, RedirectAttributes rttr) {
		Custom custom = new Custom();
		custom.setId(request.getParameter("id"));
		custom.setPw(pwdEncoder.encode(request.getParameter("pw")));	//비밀번호 암호화
		custom.setName(request.getParameter("name"));
		custom.setEmail(request.getParameter("email"));
		custom.setTel(request.getParameter("tel"));
		custom.setAddr(request.getParameter("addr1") + " $ " +request.getParameter("addr2"));
		custom.setPostcode(request.getParameter("postcode"));
		customService.changeInfo(custom);
		model.addAttribute("msg", "회원가입을 축하합니다.");
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("customDelete.do")
	public String customDelete(@RequestParam("id") String id, Model model) {
		customService.delCustom(id);
		session.invalidate();
		return "redirect:/";
	}
	
}

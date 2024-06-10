package com.spring1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring1.dto.Sample;
import com.spring1.service.SampleService;

@Controller
@RequestMapping("/test/")
public class TestController {
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="testList.do", method = RequestMethod.GET)
	public String getTestList(Model model) {
		List<Sample> list = sampleService.getSampleList();
		model.addAttribute("list", list);
		model.addAttribute("mapper", "테스트 목록1");
		return "test/testList";
	}
	
	@GetMapping("testList2.do")
	public String getTestList2(Model model) {
		List<Sample> list = sampleService.getSampleList();
		model.addAttribute("list", list);
		model.addAttribute("mapper", "테스트 목록2");
		return "test/testList";
	}
	
	@GetMapping("insTest.do")
	public String insTest(Model model) {
		return "test/insTest";
	}
	
	@PostMapping("insTestPro.do")
	public String insTestPro(HttpServletRequest request, Model model) {
		int num = sampleService.maxNum() + 1; //그 다음 번호를 계산
		
		String title = request.getParameter("title"); //폼에서 들어온 제목
		
		Sample sample = new Sample();	//빈 객체를 생성한 후
		sample.setNum(num);		//계산되어온 번호로 대입
		sample.setTitle(title);	//폼에서 들어온 제목 대입
		
		sampleService.insSample(sample);	//서비스에 객체 추가를 요청
		
		return "redirect:testList.do";
	}

	@GetMapping("getTest.do")
	public String getTest(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		Sample sample = sampleService.getSample(num);
		model.addAttribute("test", sample);
		return "test/getTest";
	}
	
	@GetMapping("modTest.do")
	public String modTest(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		Sample sample = sampleService.getSample(num);
		model.addAttribute("test", sample);
		return "test/modTest";
	}
	
	@PostMapping("modTestPro.do")
	public String modTestPro(HttpServletRequest request, Model model) {
		Sample sample = new Sample(Integer.parseInt(request.getParameter("num")), 
				request.getParameter("title"), request.getParameter("res"));
		sampleService.upSample(sample);
		return "redirect:testList.do";
	}
	
	
	@GetMapping("delTest.do")
	public String delTest(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		Sample sample = new Sample();
		sample.setNum(num);
		sampleService.delSample(sample);
		model.addAttribute("test", sample);
		return "redirect:testList.do";
	}
	
	/*
	<li><a href="${path2 }/test/testList.do">테스트 목록</a></li>
	<li><a href="${path2 }/test/getTest.do?num=1">테스트1</a></li>
	<li><a href="${path2 }/test/modTest.do?num=1">테스트1 수정</a></li>
	<li><a href="${path2 }/test/insTest.do">테스트1 추가</a></li>
	<li><a href="${path2 }/test/delTest.do?num=1">테스트1 삭제</a></li>
	*/
}

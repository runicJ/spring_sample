package com.spring.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.vo.S0611VO;

@Controller
@RequestMapping("/0611")  // 중간경로(프론트 컨트롤러의 확장자패턴 같은)
public class S0611Controller {
	
	//@GetMapping("/index")  // REST ATI 사용할 때
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex() {
		
		return "0611/index";
	}
	
	@GetMapping("/test1")
	public String getTest1(HttpServletRequest request) {  // 서블릿(이기능 Dispatcher로 사용가능 타입도 알아서 해줌)으로 사용 POJO 기능 잃어버림
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		request.setAttribute("mid", mid);
		request.setAttribute("pwd", pwd);
		
		return "0611/test1";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String getTest2(String mid, String pwd, Model model, int age, int gender) {  // 웹 타고 오면 무조건 문자인데 여기서 형변환 자동으로 해줌
		String strGender = "";
		if(gender == 1 || gender == 3) strGender = "남자";
		else strGender = "여자";
		
		model.addAttribute("mid", mid);  // 보내는 변수와 받는 변수만 일치시켜주면 된다.
		model.addAttribute("pwd", pwd);
		model.addAttribute("age", age - 1);
		model.addAttribute("gender", strGender);
		
		return "0611/test2";
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String getTest3(
			String mid, 
			String pwd, 
			Model model, int age, 
			//@RequestParam(name="gender") int sex  // 서버에 요청 변수명이 gender라고 있으면 sex 변수명으로 사용하겠다
			@RequestParam(name="gender", defaultValue = "2", required = false) int gender  // 어노테이션 매개변수 맨 아래  // 기본값(값이 안 넘어 왔을떄), 필수입력
			) {
		String strGender = "";
		if(gender == 1 || gender == 3) strGender = "남자";
		else strGender = "여자";
		
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		model.addAttribute("age", age - 1);
		model.addAttribute("gender", strGender);
		
		return "0611/test3";
	}
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public String getTest4(
			String mid, 
			String pwd, 
			Model model, int age, 
			//@RequestParam(name="gender") int sex  // 서버에 요청 변수명이 gender라고 있으면 sex 변수명으로 사용하겠다
			@RequestParam(name="gender", defaultValue = "2", required = false) int gender  // 어노테이션 매개변수 맨 아래  // 기본값(값이 안 넘어 왔을떄), 필수입력
			) {
		String strGender = "";
		if(gender == 1 || gender == 3) strGender = "남자";
		else strGender = "여자";
		
		S0611VO vo = new S0611VO();
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setAge(age);
		vo.setStrGender(strGender);
		
		model.addAttribute("vo", vo);
		
		return "0611/test4";
	}
	
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String getTest5(S0611VO vo, Model model) {  // 아래
		if(vo.getGender() == 1 || vo.getGender() == 3) vo.setStrGender("남자");
		else vo.setStrGender("여자");
		
		model.addAttribute("vo", vo);
		
		return "0611/test5";
	}
}

package com.spring.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.service.AopService;
import com.spring.sample.service.LogTestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // log 찍는 것(롬복있어야 사용가능)
@Controller  // component 써도 관계없지만 그냥 명확히 써줄 것
@RequestMapping("/aop")
public class AopController {
	
	@Autowired  // import도 있음
	LogTestService logTestService;  // 선언
	
	@Autowired
	private AopService aopService;  // 실무가면 대부분 private 앞에 써줌
	
	@RequestMapping(value = "/aopMenu", method = RequestMethod.GET)
	public String getAopMenu() {
		log.info("이곳은 AopController 객체의 getAopMenu 메소드 입니다.\n");
		return "aop/aopMenu";
	}
	
	@RequestMapping(value = "/aopTest1", method = RequestMethod.GET)
	public String getAopTest1() {		
		log.info("이곳은 AopController 객체의 getAopTest1 메소드 입니다.\n");
		
		aopService.getAopServiceTest1();
		
		return "aop/aopMenu";
	}
	
	@RequestMapping(value = "/aopTest2", method = RequestMethod.GET)
	public String getAopTest2() {		
		log.info("이곳은 AopController 객체의 getAopTest2 메소드 입니다.\n");
		
		aopService.getAopServiceTest2();
		
		return "aop/aopMenu";
	}
	
	@RequestMapping(value = "/aopTest3", method = RequestMethod.GET)
	public String getAopTest3() {		
		log.info("이곳은 AopController 객체의 getAopTest3 메소드 입니다.\n");
		
		aopService.getAopServiceTest3();
		
		return "aop/aopMenu";
	}
	
	@RequestMapping(value = "/aopTest4", method = RequestMethod.GET)
	public String getAopTest4() {		
		log.info("이곳은 AopController 객체의 getAopTest4 메소드 입니다.\n");
		
		aopService.getAopServiceTest4();
		
		return "aop/aopMenu";
	}
	
	@RequestMapping(value = "/aopTest5", method = RequestMethod.GET)
	public String getAopTest5() {		
		log.info("이곳은 AopController 객체의 getAopTest5 메소드 입니다.\n");
		
		aopService.getAopServiceT_5();
		
		return "aop/aopMenu";
	}
}

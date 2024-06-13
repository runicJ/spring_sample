package com.spring.sample.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.service.LogTestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // 롬복에서 제공하는 것  // log찍는 것(파일 이름에 용량 정해주고, 지우는 경우도 있고 파일을 새로 만듦)
@Controller  // annotation으로 controller mappingX 자동으로 Dispatcher 경로 적어주면됨
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);  // (현재 클래스에서 발생한 것에 대한 로고 사용 가능)  // static 메소드에서 사용하는 것이기 때문에 써도되고 안써도 됨(static말하는겨)  //Log4j pom.xml에서 선언 해놨기 때문에 사용가능

	@Autowired  // IoC container 스캔해서 이 안에 있는걸 가져오는 것  // 얘로 service를 불러 씀
	LogTestService logTestService;  // default  // public 아님 protected 안씀
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)  // localhost:9090/context명/ 끝에 / 까지 ex)http://localhost:9090/sample/
	@RequestMapping(value = {"/","/home","/index","/main","/h"}, method = RequestMethod.GET)  // 여러개 쓰려면 {}  // h 주소 url에 가상으로 띄워 주는 것 사용하려면 여기다 써야함
	public String home(Locale locale, Model model, String msg) {
		logger.info("Welcome home! The client locale is {}.", locale);  // 로그내용 info, warning, error, debug  // 국가 console
		//logger.debug("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("msg", msg);
		
		return "home";
	}
	
	/*
		log level 5가지 계층도 : trace(가장 자세히 보는 것) > debug(디버그 모드) > info(필요할때 명령줘서 찍어라 sysout(얘는 기록이 안됨)같은) > warn(문제가 있어보이는데 수행이 됨, 확인) > error
	*/
	
	
	  @RequestMapping(value = "/logTest", method = RequestMethod.GET) // GETMapping보단 이걸 많이 씀 
	  public String getLogTest(Model model) { 
	  	Date today = new Date();
	  
		  System.out.println(); 
		  logger.info("Logger객체를 이용한 출력"); // 롬복하고 똑같은데 해보자ㄴ
		  logger.trace("trace : {}", today); logger.debug("debug : {}", today);
		  logger.info("info : {}", today); logger.warn("warn : {}", today);
		  logger.error("error : {}", today);
		  
		  System.out.println(); 
		  log.info("롬복라이브러리(@Slf4j)객체를 이용한 출력");
		  log.trace("trace : {}", today); log.debug("debug : {}", today);
		  log.info("info : {}", today); log.warn("warn : {}", today);
		  log.error("error : {}", today);
		  
		  // 서비스 객체 호출하여 로그 찍어보기(service 아직 안담김, 생성해야함) 
		  // LogTestService logTest = new LogTestService(); 
		  // logTest.getLogTest1(); // 이게 자바에서 하는 방법(이렇게 하면 안된데 IoC container에 넣어야함(객체 생성 안함)) 
		  logTestService.getLogTest1(); // 객체 생성 안한 것(IoCcontainer에 넣으면 객체 생성 안함)
		  
		  model.addAttribute("msg", "로그파일을 출력합니다. 콘솔창을 확인하세요"); // jsp로 간게 아니라 root 컨트롤러로 간 것 위로 갔다고
		  
		  //return "/"; // jsp 부르는 것 (404 나옴) 
		  return "redirect:/"; 
	  
	  }
	 
}

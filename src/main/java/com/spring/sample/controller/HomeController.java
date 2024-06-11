package com.spring.sample.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  // annotation으로 controller mapping x 자동으로 Dispatcher 경로 적어주면됨
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	//@RequestMapping(value = "/", method = RequestMethod.GET)  // localhost:9090/context명/ 끝에 / 까지 ex)http://localhost:9090/sample/
	@RequestMapping(value = {"/","/home","/index","/main"}, method = RequestMethod.GET)  // 여러개 쓰려면 {}
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);  // 로그내용 info, warning, error, debug  // 국가 console
		//logger.debug("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}

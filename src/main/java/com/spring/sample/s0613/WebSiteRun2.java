package com.spring.sample.s0613;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebSiteRun2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xml/webSite2.xml");

		WebSiteInfor infor = (WebSiteInfor) ctx.getBean("infor");
		
		System.out.println("생성자로 값을 주입 후 Getter로 값 읽어오기");
		System.out.println("driver : " + infor.getDriver());
		System.out.println("url : " + infor.getUrl());
		System.out.println("user : " + infor.getUser());
		System.out.println("password : " + infor.getPassword());
		
		ctx.close();
	}
}
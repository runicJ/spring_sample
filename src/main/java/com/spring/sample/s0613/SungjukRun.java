package com.spring.sample.s0613;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungjukRun {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xml/sungjuk.xml");  // 외부에 만들어 놓은 xml 파일을 불러올 수 있음(resources에 있어야 함), 현재는 경로명 적어야함 (resources 하위 폴더에 있으므로) // 여기까지 가져다 쓸 준비가 됨
		
		SungjukVO vo1 = (SungjukVO) ctx.getBean("vo1");  // 자바객체 = 빈 객체  // xml에 있던게 vo에 담김		
		System.out.println("name : " + vo1.getName());
		System.out.println("kor : " + vo1.getKor());
		System.out.println("eng : " + vo1.getEng());
		System.out.println("mat : " + vo1.getMat());
		System.out.println();
		
		SungjukVO vo2 = (SungjukVO) ctx.getBean("vo2");
		System.out.println("name : " + vo2.getName());
		System.out.println("kor : " + vo2.getKor());
		System.out.println("eng : " + vo2.getEng());
		System.out.println("mat : " + vo2.getMat());
		System.out.println();
		
		SungjukVO vo3 = (SungjukVO) ctx.getBean("vo3");
		System.out.println("name : " + vo3.getName());
		System.out.println("kor : " + vo3.getKor());
		System.out.println("eng : " + vo3.getEng());
		System.out.println("mat : " + vo3.getMat());
		
		ctx.close();
	}
}

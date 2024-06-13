package com.spring.sample.s0613;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 
비만도(BMI) 계산하는 프로그램을 만드시오.
공식 : 몸무게 / (키백분율 * 키백분율)
예) 키:170Cm, 몸무게:65Kg
   비만지수 구하는 공식 : 65 / (1.7 * 1.7)
   비만지수에 대한 판정?
     저체중: 18.5미만, 정상 : 18.5∼22.9 , 비만 전 단계:23 ~ 24.9, 1단계 비만:25∼29.9, 2단계 비만:30∼34.9, 3단계 비만:35 이상
   
   데이터의 주입은 xml을 통해서 처리한다.(입력값 : 비만지수값, 개인별 성명/키/몸무게)
*/

public class BMIRun {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xml/bmi.xml");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 대한민국 기준 | 2. 세계보건기구 기준 | 종료");
		System.out.print("출력할 기준을 입력하세요? ");
		
		ArrayList<BMIVO> vos = new ArrayList<BMIVO>();
		BMIVO vo = null;

		if(sc.nextInt() == 1) vo = (BMIVO) ctx.getBean("standardKR");
		else if(sc.nextInt() == 2) vo = (BMIVO) ctx.getBean("standardWorld");
		
		vo = (BMIVO) ctx.getBean("vo1");
		vos.add(vo);
		vo = (BMIVO) ctx.getBean("vo2");
		vos.add(vo);
		vo = (BMIVO) ctx.getBean("vo3");
		vos.add(vo);
		vo = (BMIVO) ctx.getBean("vo4");
		vos.add(vo);

		vo.getService().getLine();
		System.out.println("※ 현 "+vo.getNation()+" 기준 BMI 지수는 저체중: "+vo.getNormalWeight()+"미만, 정상: "+vo.getNormalWeight()+"~"+vo.getBeforeObesity()+"미만, 비만 전: "+vo.getBeforeObesity()+"~"+vo.getStep1Obesity()+"미만, \n1단계 비만: "+vo.getStep1Obesity()+"∼"+vo.getStep2Obesity()+"미만, 2단계 비만: "+vo.getStep2Obesity()+"∼"+vo.getStep3Obesity()+"미만, 3단계 비만: "+vo.getStep3Obesity()+"이상 으로 표기하고 있습니다.");
		vo.getService().getLine();
		for(BMIVO v : vos) {
			v.bmiCalc();
			v.printBMI();
		}
		vo.getService().getLine();
	}
}

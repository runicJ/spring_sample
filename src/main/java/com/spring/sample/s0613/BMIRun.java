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
		System.out.println("| 1. 대한민국 기준 | 2. 세계보건기구 기준 | 3. BMI 백분위수(미국) |");
		System.out.print("출력할 기준을 입력하세요? ");

		int opt = sc.nextInt();
		BMIVO vo = null;
		BMIVO voM = null;
		BMIVO voF = null;
		if (opt == 1) vo = (BMIVO) ctx.getBean("standardKR");
		else if (opt == 2) vo = (BMIVO) ctx.getBean("standardWorld");
		else if (opt == 3) {
			voM = (BMIVO) ctx.getBean("perUSMale");
			voF = (BMIVO) ctx.getBean("perUSFemale");
		}
		else {
			System.out.println("선택지에 없는 번호입니다. 프로그램을 종료합니다.");
			sc.close();
			ctx.close();
			return;
		}

		ArrayList<BMIVO> vos = new ArrayList<BMIVO>();
		vos.add((BMIVO) ctx.getBean("vo1"));
		vos.add((BMIVO) ctx.getBean("vo2"));
		vos.add((BMIVO) ctx.getBean("vo3"));
		vos.add((BMIVO) ctx.getBean("vo4"));
		
        if (opt == 1 || opt == 2) {
            vo.getService().getLine();
            System.out.println("※ 현 " + vo.getNation() + " 기준 BMI 지수는 저체중: " + vo.getUnderWeight() + "미만, 정상: " + vo.getUnderWeight() + "~" + vo.getNormalWeight() + "미만, 비만 전: "
                    + vo.getNormalWeight() + "~" + vo.getBeforeObesity() + "미만, \n1단계 비만: " + vo.getBeforeObesity() + "∼" + vo.getStep1Obesity() + "미만, 2단계 비만: "
                    + vo.getStep1Obesity() + "∼" + vo.getStep2Obesity() + "미만, 3단계 비만: " + vo.getStep2Obesity() + "이상 으로 표기하고 있습니다.");
            vo.getService().getLine();

            for (BMIVO v : vos) {
                v.setUnderWeight(vo.getUnderWeight());
                v.setNormalWeight(vo.getNormalWeight());
                v.setBeforeObesity(vo.getBeforeObesity());
                v.setStep1Obesity(vo.getStep1Obesity());
                v.setStep2Obesity(vo.getStep2Obesity());
                v.setNation(vo.getNation());
                v.setService(vo.getService());

                v.bmiCalc();
                v.printBMI();
            }
            vo.getService().getLine();
        } else if (opt == 3) {
            voM.getService().getLine();
            System.out.println("※ 미국 기준 BMI 지수 (남성) - 저체중: " + voM.getUnderWeight() + "미만, 정상: " + voM.getUnderWeight() + "~" + voM.getNormalWeight() + "미만, 비만 전: "
                    + voM.getNormalWeight() + "~" + voM.getBeforeObesity() + "미만, \n1단계 비만: " + voM.getBeforeObesity() + "∼" + voM.getStep1Obesity() + "미만, 2단계 비만: "
                    + voM.getStep1Obesity() + "∼" + voM.getStep2Obesity() + "미만, 3단계 비만: " + voM.getStep2Obesity() + "이상 으로 표기하고 있습니다.");
            System.out.println("※ 미국 기준 BMI 지수 (여성) - 저체중: " + voF.getUnderWeight() + "미만, 정상: " + voF.getUnderWeight() + "~" + voF.getNormalWeight() + "미만, 비만 전: "
                    + voF.getNormalWeight() + "~" + voF.getBeforeObesity() + "미만, \n1단계 비만: " + voF.getBeforeObesity() + "∼" + voF.getStep1Obesity() + "미만, 2단계 비만: "
                    + voF.getStep1Obesity() + "∼" + voF.getStep2Obesity() + "미만, 3단계 비만: " + voF.getStep2Obesity() + "이상 으로 표기하고 있습니다.");
            voM.getService().getLine();

            for (BMIVO v : vos) {
                BMIVO voUS = v.getGender().equals("남성") ? voM : voF;

                v.setUnderWeight(voUS.getUnderWeight());
                v.setNormalWeight(voUS.getNormalWeight());
                v.setBeforeObesity(voUS.getBeforeObesity());
                v.setStep1Obesity(voUS.getStep1Obesity());
                v.setStep2Obesity(voUS.getStep2Obesity());
                v.setNation(voUS.getNation());
                v.setService(voUS.getService());

                v.bmiCalc();
                v.printBMI();
            }
            voM.getService().getLine();
        }

		System.out.println("같은 몸무게여도 지방량, 근육량, 골격 등에 따라서 다 다르게 보일 수 있는 점^^ 참고 부탁드립니다.");
		
		sc.close();
		ctx.close();
	}
}

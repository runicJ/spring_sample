package com.spring.sample.s0613;

public class BMIService {

	public void getLine() {
		System.out.println("===============================================================================");
	}
	
	public BMIVO calc(double underWeight, double normalWeight, double beforeObesity, 
			double step1Obesity, double step2Obesity, int height, int weight) {
		double heightM = height * 0.01;
		double bmi = weight / (heightM * heightM);
		String step = "";
		if(bmi < underWeight) step="저체중";
		else if(bmi < normalWeight) step="정상";
		else if(bmi < beforeObesity) step="비만 전";
		else if(bmi < step1Obesity) step="1단계 비만";
		else if(bmi < step2Obesity) step="2단계 비만";
		else step="3단계 비만";

		BMIVO vo = new BMIVO();
		vo.setBmi(bmi);
		vo.setStep(step);
		
		return vo;
	}

	public void printBMI(String nation, String name, double bmi, String step) {
		System.out.println(nation + "기준 "+name+"님의 BMI 지수는 "+String.format("%.2f", bmi)+"% 이고, "+step+"단계 입니다.");
	}

//    public String Tips(double bmi, String step) {
//        if (step.equals("저체중")) {
//            return "저체중입니다. 영양가 있는 음식을 섭취하세요.";
//        } 
//        else if (step.equals("정상")) {
//            return "정상 체중입니다. 삐빅";
//        } 
//        else if (step.equals("비만 전")) {
//            return "비만 전 단계입니다. 꾸준한 운동과 적절한 식단이 필요합니다.";
//        } 
//        else if (step.equals("1단계 비만")) {
//            return "1단계 비만입니다. 규칙적인 운동과 식단 조절이 필요합니다.";
//        } 
//        else if (step.equals("2단계 비만")) {
//            return "2단계 비만입니다. 건강 관리에 유의하세요.";
//        } 
//        else {
//            return "3단계 비만입니다. 건강 관리가 필요합니다. 전문의와 상담을 추천합니다.";
//        }
//    }
}

package com.spring.sample.s0613;

public class BMIService {

	public void getLine() {
		System.out.println("===============================================================================");
	}
	
	public BMIVO calc(double underWeight, double normalWeight, double beforeObesity, 
			double step1Obesity, double step2Obesity, double step3Obesity, int height, int weight) {
		double heightM = height * 0.01;
		double bmi = weight / (heightM * heightM);
		String step = "";
		if(bmi > underWeight) step="저체중";
		else if(bmi >= normalWeight) step="정상";
		else if(bmi >= beforeObesity) step="비만 전";
		else if(bmi >= step1Obesity) step="1단계 비만";
		else if(bmi >= step2Obesity) step="2단계 비만";
		else if(bmi >= step3Obesity) step="3단계 비만";

		BMIVO vo = new BMIVO();
		vo.setBmi(bmi);
		vo.setStep(step);
		
		return vo;
	}

	public void printBMI(String name, double bmi, String step) {
		System.out.println(name + "님의 BMI 지수는 "+String.format("%.2f", bmi)+"% 이고, "+step+"단계 입니다.");
	}
		
}

package com.spring.sample.s0613;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BMIVO {
	private String name;
	private int height;
	private int weight;
	private String gender;
	
	private String nation;
	private double underWeight;
	private double normalWeight;
	private double beforeObesity;
	private double step1Obesity;
	private double step2Obesity;
	
	private double bmi;
	private String step;
	
//	@Autowired
//	BMIService service;
	
	BMIService service = new BMIService(); 
	
	public void bmiCalc() {
		BMIVO vo = service.calc(underWeight, normalWeight, beforeObesity, step1Obesity, step2Obesity, height, weight);
		this.bmi = vo.getBmi();
		this.step = vo.getStep();
	}
	
	public void printBMI() {
		service.printBMI(nation, name, bmi, step);
	}
}

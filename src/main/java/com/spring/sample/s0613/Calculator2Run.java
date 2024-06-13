package com.spring.sample.s0613;

public class Calculator2Run {
	public static void main(String[] args) {  // 자바에서 실행하려면 main 있어야
		Calculator2 calc = new Calculator2(50, 100);  // calculator2에 기본생성자 없어서 에러 => 값 넣어줘야함
		
//		calc.setSu1(100);  // setter를 통한 값의 주입  / 다른방법 생성자를 통한 값의 주입
//		calc.setSu2(200);
		
		calc.add();
		calc.sub();
		calc.mul();
		calc.div();
	}
}// 여기서 Run on serverX java application
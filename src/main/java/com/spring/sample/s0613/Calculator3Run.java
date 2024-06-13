package com.spring.sample.s0613;

import java.util.Scanner;

public class Calculator3Run {
	public static void main(String[] args) {  // 자바에서 실행하려면 main 있어야
		Scanner sc = new Scanner(System.in);
		
		// 0이 입력될 때까지 사칙연산 처리하시오.
		CalculatorVO vo = new CalculatorVO();
		CalculatorService service = new CalculatorService();
		
		int su = 0;
		while(true) {
			System.out.print("첫번째 수를 입력하세요?(작업종료 0) ");
			su = sc.nextInt();
			
			if(su != 0) {
				if(su > 0) vo.setSu1(su);
				else {
					vo.setSu1(su);
					continue;  // 위로 올려줌
				}
			}
			else break;
			
			System.out.print("두번째 수를 입력하세요?(작업종료 0) ");
			vo.setSu2(sc.nextInt());
			
			service.add(vo.getSu1(), vo.getSu2());
			service.sub(vo.getSu1(), vo.getSu2());
			service.mul(vo.getSu1(), vo.getSu2());
			service.div(vo.getSu1(), vo.getSu2());
		}
		System.out.println("작업끝...");
		
		sc.close();
	}
}
package com.spring.sample.s0613;

public class CalculatorService {
	
	public void add(int su1, int su2) {
		System.out.println(su1 + " + " + su2 + " = " + (su1 + su2));
	}
	public void sub(int su1, int su2) {
		System.out.println(su1 + " - " + su2 + " = " + (su1 - su2));
	}
	public void mul(int su1, int su2) {
		System.out.println(su1 + " * " + su2 + " = " + (su1 * su2));
	}
	public void div(int su1, int su2) {
		if(su2 != 0) {  // 에러 막기 위해 넣음(두번쨰 수가 0이 아닐떄)
			System.out.println(su1 + " / " + su2 + " = " + (su1 / su2));
		}
		else System.out.println("0으로 나눌 수 없습니다.");
	}
	
}

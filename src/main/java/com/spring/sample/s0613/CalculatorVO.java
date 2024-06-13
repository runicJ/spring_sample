package com.spring.sample.s0613;

public class CalculatorVO {
	private int su1;
	private int su2;
	
	public int getSu1() {
		return su1;
	}
	public void setSu1(int su1) {
		bigyo(su1);
		this.su1 = su1;
	}
	public int getSu2() {
		return su2;
	}
	public void setSu2(int su2) {
		bigyo(su2);
		this.su2 = su2;
	}
	
	private int bigyo(int su) {
		int res = 0;  // 양수의 가장 작은 값
		if(su < 0) {
			System.out.println("입력되는 수는 양수만 가능합니다.");
		}
		else res = su;
		
		return res;
	}
}

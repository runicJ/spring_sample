package com.spring.sample.s0613;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data  // 아래 3개 합친것, 그러나 문제가 생길 여지가 있음
@Getter
@Setter
@ToString
public class Calculator2 {  //기본생성자 있으나 값주입x => 사용자 정의 만듦(생성자를 통한 값의 주입 방법)
	private int su1;
	private int su2;
	
	public Calculator2(int su1, int su2) {
		super();
		this.su1 = su1;
		this.su2 = su2;
	}	
	
	public void add() {
		System.out.println(su1 + " + " + su2 + " = " + (su1 + su2));
	}
	public void sub() {
		System.out.println(su1 + " - " + su2 + " = " + (su1 - su2));
	}
	public void mul() {
		System.out.println(su1 + " * " + su2 + " = " + (su1 * su2));
	}
	public void div() {
		System.out.println(su1 + " / " + su2 + " = " + (su1 / su2));
	}
}

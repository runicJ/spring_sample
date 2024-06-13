package com.spring.sample.s0613;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data  // 아래 3개 합친것, 그러나 문제가 생길 여지가 있음
@Getter
@Setter
@ToString
public class Calculator1 {
	private int su1;
	private int su2;
	
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

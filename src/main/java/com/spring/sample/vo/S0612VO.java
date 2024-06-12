package com.spring.sample.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter  // tom에 넣어놔야함(maven repository)
@Setter
@ToString
//@AllArgsConstructor  // 생성자 등
//@Data
public class S0612VO {
	private String name;
	private String NName;	 // 두번째 글자가 대문자이면 에러 발생 => 첫번째 문자도 대문자이면 사용가능
	private String mid;
	private String pwd;
	private int age;
	private int gender;
	private String strGender;
}
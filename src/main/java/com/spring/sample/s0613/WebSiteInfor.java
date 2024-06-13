package com.spring.sample.s0613;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data  // 생성자 때문에 이거 안씀
@Getter
@Setter
//@RequiredArgsConstructor  // 필수 입력(만들어 놓은 걸 모두 입력하겠다.) => 생성자를 통한 값 주입 위해서
//@AllArgsConstructor
@ToString
public class WebSiteInfor {
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public WebSiteInfor() {}
	
//	public WebSiteInfor(String driver, String url, String user, String password) {  // 위의 필드 순서대로 나옴
//		super();
//		this.driver = driver;
//		this.url = url;
//		this.user = user;
//		this.password = password;
//	}
}

package com.spring.sample.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // 롬복에 있는 라이브러리
//@Component  // Service보다 더 큰 객체(가장 포괄적인)
@Service  // 명확하게 써줌
public class LogTestService {  // 클래스명(LogTestService)
	//log. 여기선 안나옴
	public void getLogTest1() {
		System.out.println();
		log.info("이곳은 LogTestService 객체의 getLogTest1() 메소드 입니다.");
		System.out.println();
	}
}  // service를 bean(IoC의 객체)으로 만들어야함 => annotation으로 만들어 사용 // Controller, service, repository 어느 것이든 관계없음

//@Component
/*
 * @Component 어노테이션을 이용하면 Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있다. 빈
 * 등록자체를 빈 클래스 자체에다가 할 수 있다는 의미이다.
 * 
 * @Component 어노테이션은 기본적으로 타입기반의 자동주입 어노테이션이다.
 * 
 * @Autowired, @Resource와 비슷한 기능을 수행한다고 할 수 있겠다.
 * 
 * @Component 어노테이션을 xml 설정파일에서 설정하는 방법이다.
 */
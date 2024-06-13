package com.spring.sample.s0613;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungjukRun3 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xml/sungjuk.xml");  // 외부에 만들어 놓은 xml 파일을 불러올 수 있음(resources에 있어야 함), 현재는 경로명 적어야함 (resources 하위 폴더에 있으므로) // 여기까지 가져다 쓸 준비가 됨
		
		SungjukVO[] vos = {(SungjukVO) ctx.getBean("vo1"),(SungjukVO) ctx.getBean("vo2"),(SungjukVO) ctx.getBean("vo3")};  // 타입이 같으므로 배열로 만들 수 있음
		
		SungjukService service = new SungjukService();
		
		service.getLine();
		service.printTitle();
		service.getLine();

		for(SungjukVO v : vos) {
			SungjukVO sVo = service.calc(v);
			service.printSungjuk(sVo);
		}
		service.getLine();
		
		ctx.close();
	}
}

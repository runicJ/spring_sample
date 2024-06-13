package com.spring.sample.s0613;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungjukRun2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xml/sungjuk.xml");  // 외부에 만들어 놓은 xml 파일을 불러올 수 있음(resources에 있어야 함), 현재는 경로명 적어야함 (resources 하위 폴더에 있으므로) // 여기까지 가져다 쓸 준비가 됨
		
		ArrayList<SungjukVO> vos = new ArrayList<SungjukVO>();
		SungjukVO vo = null;  // 필요할때 생성하면 됨. => null
		
		vo = (SungjukVO) ctx.getBean("vo1");
		vos.add(vo);

		vo = (SungjukVO) ctx.getBean("vo2");
		vos.add(vo);
		
		vo = (SungjukVO) ctx.getBean("vo3");
		vos.add(vo);
		
		SungjukService service = new SungjukService();
		
		service.getLine();
		service.printTitle();
		service.getLine();
		// 여러명 이니까 반복문
		for(SungjukVO v : vos) {
			SungjukVO sVo = service.calc(v);
			service.printSungjuk(sVo);
		}
		service.getLine();
		
		ctx.close();
	}
}

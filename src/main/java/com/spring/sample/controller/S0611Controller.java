package com.spring.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sample.vo.S0611VO;
import com.spring.sample.vo.S0612VO;

@Controller  // Ioc컨테이너 안에 component > controller, service, 레파지토리  // beans라는 객체
@RequestMapping("/0611")  // 중간경로(프론트 컨트롤러의 확장자패턴 같은)
public class S0611Controller {  // service와 역할분담 잘 해야 함 // 여기서는 교통정리 담당
	
	//@GetMapping("/index")  // REST ATI 사용할 때
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex() {
		
		return "0611/index";  // 폴더명/jsp파일명 // 예외가 있다면 값을 다시 가져올때 경로명을 적어줌
	}
	
	@GetMapping("/test1")
	public String getTest1(HttpServletRequest request) {  // 서블릿(이기능 Dispatcher로 사용가능 타입도 알아서 해줌)으로 사용 POJO 기능 잃어버림
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		request.setAttribute("mid", mid);
		request.setAttribute("pwd", pwd);
		
		return "0611/test1";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String getTest2(String mid, String pwd, Model model, int age, int gender) {  // 웹 타고 오면 무조건 문자인데 여기서 형변환 자동으로 해줌
		String strGender = "";
		if(gender == 1 || gender == 3) strGender = "남자";
		else strGender = "여자";
		
		model.addAttribute("mid", mid);  // 보내는 변수와 받는 변수만 일치시켜주면 된다.
		model.addAttribute("pwd", pwd);
		model.addAttribute("age", age - 1);
		model.addAttribute("gender", strGender);
		
		return "0611/test2";
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String getTest3(
			String mid, 
			String pwd, 
			Model model, int age, 
			//@RequestParam(name="gender") int sex  // 서버에 요청 변수명이 gender라고 있으면 sex 변수명으로 사용하겠다
			@RequestParam(name="gender", defaultValue = "2", required = false) int gender  // 어노테이션 매개변수 맨 아래  // 기본값(값이 안 넘어 왔을떄), 필수입력
			) {
		String strGender = "";
		if(gender == 1 || gender == 3) strGender = "남자";
		else strGender = "여자";
		
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		model.addAttribute("age", age - 1);
		model.addAttribute("gender", strGender);
		
		return "0611/test3";
	}
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public String getTest4(
			String mid, 
			String pwd, 
			Model model, int age, 
			//@RequestParam(name="gender") int sex  // 서버에 요청 변수명이 gender라고 있으면 sex 변수명으로 사용하겠다  // 변수명 바꿔쓰고 싶을때
			@RequestParam(name="gender", defaultValue = "2", required = false) int gender  // 어노테이션 매개변수 맨 아래  // 기본값(값이 안 넘어 왔을떄), 필수입력
			) {
		String strGender = "";
		if(gender == 1 || gender == 3) strGender = "남자";
		else strGender = "여자";
		
		S0611VO vo = new S0611VO();
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setAge(age);
		vo.setStrGender(strGender);
		
		model.addAttribute("vo", vo);
		
		return "0611/test4";
	}
	
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String getTest5(S0611VO vo, Model model) {  // 알아서 가져와서 vo에 담고 선언과 동시에 받아버림  // 매개변수 안에 적어주면 생성이 되는 것인가? MemberVO vo = dao.getMidSearch(mid); 얕은복사 생성의 개념처럼 자료를 담아온것
		if(vo.getGender() == 1 || vo.getGender() == 3) vo.setStrGender("남자");
		else vo.setStrGender("여자");
		
		model.addAttribute("vo", vo);
		
		return "0611/test5";
	}
	
	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public ModelAndView getTest6(S0611VO vo) {  // vo 객체(위 화살표)  // 이전에는 무조건 httpServlet String으로 넘어온것 지금은 원래 타입으로 넘어와서 자유로움
		ModelAndView mv = new ModelAndView("0611/test6");  // view를 넣어준 것
		
		mv.addObject("vo", vo);  // ModelAndView를 쓰고 또 Model을 쓸 필요없음
		
		// return "0611/test6";  // 폴더명/
		return mv;
	}
	// 오버로딩 : 같은 이름의 생성자, 메소드 존재 가능(매개변수 타입, 이름, 개수는 같으면 안됨)
	@RequestMapping(value = "/test7", method = RequestMethod.POST)  // 405 전송방식(POST,GET) 오류
	public ModelAndView postTest7(S0611VO vo, String name) {
		// post 방식에선 한글이 깨짐
		ModelAndView mv = new ModelAndView("0611/test7");
		
		mv.addObject("vo", vo);
		mv.addObject("name", name);
		
		return mv;
	}
	
	//@RequestMapping(value = "/test7", method = RequestMethod.POST)  // 405 전송방식(POST,GET) 오류
	/*
	@PostMapping("/test8")
	public ModelAndView getTest8(S0611VO vo, HttpServletRequest request) throws UnsupportedEncodingException {		
		request.setCharacterEncoding("utf-8");  // post 방식에선 한글이 깨짐
		
		String name = request.getParameter("name");
		
		ModelAndView mv = new ModelAndView("0611/test8");
		
		mv.addObject("vo", vo);
		mv.addObject("name", name);
		
		return mv;
	}
	*/
	
	@PostMapping("/test8")
	public ModelAndView getTest8(S0612VO vo, String name) {		
		ModelAndView mv = new ModelAndView("0611/test8");
		
		//System.out.println("vo : " + vo);
		
		mv.addObject("vo", vo);
		mv.addObject("name", name);
		
		return mv;
	}
	
	//@PostMapping("/test9")
	@RequestMapping(value = "/test9", method = RequestMethod.GET)
	public String getTest9() {
		return "0611/test9";
	}
	
	// form에 action이 없으면 주소창의 주소 경로로 감  // POST도 안쓰여 있으면 GET으로 감(제어되는 것 없으면 무한이 왔다갔다)
	@RequestMapping(value = "/test9", method = RequestMethod.POST)  // GET과 POST만 다름
	public String postTest9(S0612VO vo, Model model) {
		//System.out.println("vo : " + vo);
		model.addAttribute("vo",vo);  // 서버에 갔다온거임 // 인증하고 와도 회원가입 폼에 입력한 것이 그대로 남아있음(세션이나 쿠키도 아님)
		return "0611/test9";
	}

	@RequestMapping(value = "/test10", method = RequestMethod.GET)  // GET 방식으로 form 태그를 부름
	public String getTest10() {
		return "0611/test10";
	}

	@RequestMapping(value = "/test10", method = RequestMethod.POST)
	public String getTest10(S0612VO vo, Model model) {  // 저장소 request, session 둘다 가능하나 spring에서는 Model이나 ModelAndView 권장
		String viewPage = "";
		if(vo.getMid().substring(0,1).equals("a")) {
			model.addAttribute("msg", "회원 가입되었습니다.");
			viewPage = "0611/test10Ok";
		}
		else {
			model.addAttribute("msg", "회원 가입실패~~");
			viewPage = "0611/test10";
		}
		model.addAttribute("vo", vo);  // 실패하고 돌아올 때 값이 그대로 남아있음(세션처리x)  // 보여주는 것은 POST아니고 그냥 forward 해준것
		
		return viewPage;
	}
	
	@RequestMapping(value = "/test11", method = RequestMethod.GET)
	public String getTest11(Model model,
			@RequestParam(name = "name", defaultValue = "홍길동", required = false) String name,
			@RequestParam(name = "nName", defaultValue = "홍장군", required = false) String nName,
			@RequestParam(name = "age", defaultValue = "20", required = false) int age,
			@RequestParam(name = "mid", defaultValue = "hkd1234", required = false) String mid,
			@RequestParam(name = "pwd", defaultValue = "1234", required = false) String pwd,
			@RequestParam(name = "strGender", defaultValue = "남자", required = false) String strGender,
			@RequestParam(name = "msg", defaultValue = "", required = false) String msg
			) {
		
		model.addAttribute("name", name);
		model.addAttribute("nName", nName);
		model.addAttribute("age", age);
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		model.addAttribute("strGender", strGender);
		model.addAttribute("msg", msg);  // msg 받아서 다시 실어서 보냄
		//System.out.println("회원 가입폼 창으로 이동..."); //1,3
		
		return "0611/test11";  // 여기는 폴더명/파일명
	}
	
	@RequestMapping(value = "/test11", method = RequestMethod.POST)
	public String postTest11(Model model, S0612VO vo) {
		if(vo.getMid().substring(0,1).equals("a")) {
			model.addAttribute("vo", vo);
			model.addAttribute("msg", "회원 가입되었습니다.");
			return "0611/test10Ok";
		}
		else {
			model.addAttribute("msg", "회원 가입실패~~");  // 내용이 안담겨있음 model.addAttribute 해도 RequestParam으로 그냥 forward된거라서 vo에 저장이 어차피 안 되어 있음  // 주소창 보면 get방식에 쿼리스트링
			//System.out.println("회원가입 실패 통과..."); //2
//			model.addAttribute("name", vo.getName());
//			model.addAttribute("nName", vo.getNName());
//			model.addAttribute("age", vo.getAge());
//			model.addAttribute("mid", vo.getMid());
//			model.addAttribute("pwd", vo.getPwd());
//			model.addAttribute("strGender", vo.getStrGender());  // 이렇게 하면 당연히 나옴
			
			return "redirect:/0611/test11";  // 이건 경로로 보내는 것(경로 url로 보고 싶은것 => redirect:/폴더명/파일명) => 그냥 우리끼리 약속(jsp는 앞에 / 넣지 말자 -> 프로그램이 헷갈림) // 다시 갔다가(forward)하지말고 다시 한번 찾아줘(controller경로로) => jsp로 가지 말고 // POST에서 jsp를 부른게 아니라 POST에서 controller를 부른 것
		}		
	}
	
	@RequestMapping(value = "/test12/{mid}/{pwd}", method = RequestMethod.GET)  // /test12까지만 주소로 보겠다는 얘기 => 나머지는 값임({변수명})
	public String postTest12(Model model,
			@PathVariable String mid,  // 재정의 함
			@PathVariable String pwd  // 2개니까 2개 받아줘야함  // PathVariable 손을 두개 벌리고 있는데 값이 안넘어오면(없으면) 404 뜸
			) {
		
		model.addAttribute("mid", mid);  // 237행이 뒤에 mid임
		model.addAttribute("pwd", pwd);
		
		return "0611/test12";  // jsp로 간다는 것
	}
	
	@GetMapping("/test13")
	public String getTest13() {
		return "0611/test13";
	}
	
	@GetMapping("/test13/{mid}/{pwd}")
	public String getTest13(Model model,
			@PathVariable String mid,  // 재정의
			@PathVariable String pwd
			) {
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		
		return "0611/test13Ok";
	}
	
	@GetMapping("/test14")
	public String getTest14() {
		return "0611/test14";
	}
	
	//@GetMapping("/test14/{mid}/{pwd}")
	//@GetMapping("/test14/{mid}-{pwd}")
	//@GetMapping("/test14/{mid}A{pwd}")
	//@GetMapping("/test14/{mid}_____________________{pwd}")
	@GetMapping("/{mid}/test14/{pwd}")
	public String getTest14(Model model,
			@PathVariable String mid,  // 재정의
			@PathVariable String pwd
			) {
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		
		return "0611/test14Ok";
	}
	
	@RequestMapping(value = "/test15", method = RequestMethod.GET)  // 가급적 어노테이션 사용시 첫글자 대문자로 쓰는 습관 들이기  // /test15는 index가 부름
	public String getTest15() {
		return "0611/test15";
	}
	
	@RequestMapping(value = "/test15", method = RequestMethod.POST)
	public String postTest15(S0612VO vo, Model model) {
		/*
		if(vo.getMid().substring(0,1).equals("a")) {
			model.addAttribute("vo", vo);
			model.addAttribute("msg", "회원 가입되었습니다.");
			model.addAttribute("url", "/0611/test15");  // 경로을 쓰는 것(파일명x)
		}
		else {
			model.addAttribute("msg", "회원 가입실패~~");
			model.addAttribute("url", "/0611/index");
		}
		
		return "include/message";  // 이렇게 사용해도 됨
		//return "redirect:/message/memberInputOk";
		*/
		
		if(vo.getMid().substring(0,1).equals("a")) {
			//model.addAttribute("vo", vo);
//			model.addAttribute("msg", "회원 가입되었습니다.");
//			model.addAttribute("url", "/0611/test15");  // 경로을 쓰는 것(파일명x)
			return "redirect:/message/memberInputOk?mid=" + vo.getMid();  // messageController에 메시지 관련된 것 모두 위임  // mid는 pass variable이 아님
		}
		else {
//			model.addAttribute("msg", "회원 가입실패~~");
//			model.addAttribute("url", "/0611/index");
			return "redirect:/message/memberInputNo";
		}
		
		//return "include/message";
	}
}
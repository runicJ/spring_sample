package com.spring.sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy  // 프록시
@Component  // 이건 service 객체 아님
@Aspect  // 아래 전체가 aspect // aop클래스가 되는 것(필터 같은 것은 자동적으로 aop 기능 => 따로 안적어줌)
public class AspectTest {
	/*
	// Advice
	@Around("execution(* com.spring.sample.service.AopService.getAopServiceTest1(..))")  // around 시작과 끝 다 됨 // (PointCut 설정) - advice 사용범위 설정 : ("execution-실행명령어(타입 패키지명.클래스명.메소드명(매개변수))")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {  //AopService 객체 실행 시점 // 실행 시점(안쓰면 위 메소드가 실행되는 시점0
		System.out.println("\n이곳은 aroundAdvice 메소드(전) 입니다. : " + joinPoint);

		joinPoint.proceed();  // 예외 처리 해야함
		
		System.out.println("\n이곳은 aroundAdvice 메소드(후) 입니다." + joinPoint);
	}
	
	@Before("execution(* com.spring.sample.service.AopService.getAopServiceTest1(..))")
	public void beforAdvice(JoinPoint joinPoint) throws Throwable {  // ProceedingJoinPoint 첫번째 한번만 써줌  // 위쪽 화살표만 나옴
		//joinPoint.proceed();
		
		System.out.println("\n이곳은 beforAdvice 메소드 입니다.");
	}
	
	@AfterReturning("execution(* com.spring.sample.service.AopService.getAopServiceTest1(..))")  // error가 안나면 실행  // 아래쪽 화살표만
	public void afterReturning(JoinPoint joinPoint) throws Throwable {		
		System.out.println("\n이곳은 AfterReturningAdvice 메소드 입니다.");
	}
 */
	
	/*
	@Pointcut("execution(* com.spring.sample.service.AopService.getAopServiceTest1(..))")
	private void cut() {}
	
	@Before("cut()")
	public void beforeAdvice(JoinPoint joinPoint) throws Throwable {
		System.out.println("\n이곳은 beforeAdvice메소드 입니다. : " + joinPoint);
	}
	
	@AfterReturning("cut()")
	public void afterReturningAdvice(JoinPoint joinPoint) throws Throwable {
		System.out.println("\n이곳은 afterReturningAdvice메소드 입니다.");
	}
	*/
	
	/*
	@Around("execution(execution(* com.spring.sample.service.AopService.getAopServiceTest*(..)")
	public void aroundAdvice() {		
		System.out.println("\n이곳은 aroundAdvice메소드 입니다.");
	}
	*/
	
	@Pointcut("execution(* com.spring.sample.service.AopService.getAopServiceTest2(..))")
	private void cut() {}
	
	@AfterReturning(value="cut()", returning="obj")
	public void aroundAdvice(Object obj) {
		System.out.println("\n이곳은 AfterReturningAdvice메소드 입니다. : obj = " + obj);
	}
	
	/*
	@Around("execution(* com.spring.sample.service.AopService.getAopServiceTest*(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("\n이곳은 aroundAdvice메소드 입니다.");
		long startTime = System.nanoTime();
		try {
			Object result = joinPoint.proceed();  // 뭐가 올지 모르니까 가장 상위 object로 줌
			return result;
		} finally {  // catch 안쓰면 위에 throws // 위에 썼어도 try 해주는게 좋음 // 이거 하든 안하든 마지막 finally(성공하든 실패하든 실행)
			long endTime = System.nanoTime();
			long executionTime = endTime - startTime;
			System.out.println("수행시간 : "+executionTime+"ns");
		}
	}
	*/
}

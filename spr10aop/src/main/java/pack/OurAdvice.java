package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// Aspect 클래스 (Advice용)
public class OurAdvice {
	public Object kbs(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("<<<<<<<<<<<<<<<<<<<<");
		// 수행 시간 check (모니터링의 일종)
		StopWatch stopWatch = new StopWatch(); // Spring 내장 객체
		stopWatch.start();
		
		System.out.println("핵심 메소드 수행 전 관심사항(로그인, 시큐리티 등) 실행");
		
		Object object = joinpoint.proceed(); // 선택된 핵심 메소드 수행
		
		System.out.println("핵심 메소드 수행 후 뭔가를 실행 🎵🎶");
		
		stopWatch.stop();
		System.out.println("처리 시간: " + stopWatch.getTotalTimeMillis());
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
		
		return object;
	}
}

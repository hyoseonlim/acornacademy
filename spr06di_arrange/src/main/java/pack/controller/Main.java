package pack.controller;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*
		context.close()가 불가능하여 경고 발생. 따라서 아래 방법 사용
		ApplicationContext context = new ClassPathXmlApplicationContext("arrange.xml"); // 앞에 classpath: 생략 가능
		*/
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("arrange.xml");

		System.out.println("------ Singleton 확인하세요 ------");
		MessageImpl impl1 = (MessageImpl)context.getBean("msgImpl");
		impl1.sayHi();
		MessageImpl impl2 = (MessageImpl)context.getBean("msgImpl");
		impl2.sayHi();
		System.out.println("객체 주소: " + impl1 + " / " + impl2); 
		// 둘의 주소 같음 -> 싱글톤! 
		// 스프링의 특징: arrange.xml에서 인스턴스 시 new 하는 것이 아니라 싱글톤을 만드는 것
		// scope=singleton이 기본
		
		// 다형성을 위해 위 방법이 아닌 아래 방법처럼 인터페이스를 사용하자
		System.out.println("\n------ Polymorphism 확인하세요 (1) ------");
		MessageInter inter1 = (MessageInter)context.getBean("msgImpl");
		inter1.sayHi();
		
		System.out.println("\n------ Polymorphism 확인하세요 (2) ------");
		MessageInter inter2 = context.getBean("msgImpl", MessageInter.class); // casting이 아닌 다른 방법
		inter2.sayHi();
	
		context.close();
	}
}
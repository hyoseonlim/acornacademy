package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// 처리 1: 전통적인 방법 (legacy)
		Message1 m1 = new Message1();
		m1.sayHello("김밥밥");
		Message2 m2 = new Message2();
		m2.sayHello("신기루");
		
		System.out.println("-------------------------------");
		
		MessageInter inter;
		inter = m1;
		inter.sayHello("손오공");
		inter = m2;
		inter.sayHello("저팔계");
		
		
		// 처리 2: Spring 방법 (annotation, xml 사용 가능. 여기서는 xml!)
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/init.xml"); // src/main/pack에 있을 때
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml"); // src/main/resources에 있을 때 (앞에 classpath: 생략 가능)
		MessageInter interA = (MessageInter)context.getBean("msg1");
		interA.sayHello("유비");
		MessageInter interB = (MessageInter)context.getBean("msg2");
		interB.sayHello("관우");
	}

}

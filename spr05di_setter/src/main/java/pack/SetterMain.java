package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		OurProcess our = (OurProcess)context.getBean("our"); 
		// configuration.xml에 있는 id로 가져옴
		// 최상위 슈퍼클래스 Object로 넘어오므로 casting 필요 
		System.out.println(our); // .toString() 오버라이딩 했으니까 객체의 주소가 나오지 않고 원하는 결과 나오므로 생략하고 객체변수 이름만 써도 됨
	}

}

package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		MyProcess myProcess = (MyProcess)context.getBean("myProcess"); 
		// configuration.xml에 있는 id로 가져옴
		// 최상위 슈퍼클래스 Object로 넘어오므로 casting 필요 
		myProcess.displayData();

	}

}

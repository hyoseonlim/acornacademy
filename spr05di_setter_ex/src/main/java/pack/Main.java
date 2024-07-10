package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		
		MyProcess myProc = (MyProcess)context.getBean("myProc");
		myProc.inputData();
		myProc.showData();
	}

}

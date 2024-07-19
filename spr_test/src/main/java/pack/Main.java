package pack;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("init.xml");

		MyProcess my = (MyProcess)context.getBean("my");
		my.displayGugudan();
	
		context.close();
	}
}
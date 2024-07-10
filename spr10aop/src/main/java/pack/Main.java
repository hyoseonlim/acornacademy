package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopinit.xml");
		LogicInter inter = context.getBean("logicImpl", LogicInter.class);
		inter.selectDataProcess1();
		inter.selectDataProcess2();

	}

}

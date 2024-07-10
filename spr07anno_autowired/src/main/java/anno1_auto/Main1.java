package anno1_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Configuration
//@ComponentScan(basePackages = "anno1_auto") // xml로부터 완전히 독립적임. 해당 annotation으로 해결됨
public class Main1 {
	public static void main(String[] args) {
		// Autowired에 대한 메인
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main1.class);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("anno1.xml");
		SenderProcess process = context.getBean("senderProcess", SenderProcess.class);
		process.dispData();		
	}
}

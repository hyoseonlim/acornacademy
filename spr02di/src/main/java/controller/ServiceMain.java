package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.DataDao;
import model.DataDaoImpl;

public class ServiceMain {
	public static void main(String[] args) {
		// <전통적 방법>
		
		// DB 처리 객체 생성
		DataDaoImpl impl = new DataDaoImpl();
		DataDao dataDao = impl; // polymorphisim
		
		// BL 관련 객체 생성
		ProcessServiceImpl serviceImpl = new ProcessServiceImpl(dataDao);
		ProcessService processService = serviceImpl; // polymorphisim
		processService.selectProcess();
		
		System.out.println("-------------------------------");
		
		// <Spring 방법>
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml"); // resources 폴더에 있으니까 파일명만 써도 찾기 가능
		ProcessService processService2 = (ProcessService)context.getBean("serviceImpl");
		processService2.selectProcess();
	}
}

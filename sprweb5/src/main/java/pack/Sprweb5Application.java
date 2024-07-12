package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Spring Boot에서 가장 중요한 annotation 🌟
public class Sprweb5Application {
	
	@Autowired
	My my;
	
	@Autowired
	ProcessServiceImpl processServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(Sprweb5Application.class, args).getBean(Sprweb5Application.class).execute();
		// 자동 생성된 기존 코드: SpringApplication.run(Sprweb5Application.class, args)
		// .getBean(Sprweb5Application.class).execute() 을 추가했음
		// .execute()는 아래 내부 정의 메소드야
	}
	
	private void execute() {
		System.out.println("execute 메소드 수행");
		my.aaa();
		processServiceImpl.selectProcess();
	}

}

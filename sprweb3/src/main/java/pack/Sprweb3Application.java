package pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan 등 여러 어노테이션을 담고 있음
public class Sprweb3Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb3Application.class, args);
	}

}

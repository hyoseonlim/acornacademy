package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("thymeleaf")
	public String start1(Model model) {
		model.addAttribute("msg", "Thymeleaf 만세!🎉");
		model.addAttribute("msg2", "🐻‍❄️🎵🌷🧸🪴🐻");
		
		// DTO 자료 출력용
		Product product1 = new Product();
		product1.setCode("10");
		product1.setSang("삼다수(3L)");
		product1.setPrice("1700");
		product1.setSu("5");
		
		model.addAttribute("product1", product1); // "product1"라는 이름의 key로 product1 담음
		
		Product product2 = new Product();
		product2.setCode("20");
		product2.setSang("고구마빵");
		product2.setPrice("2300");
		product2.setSu("7");
		
		model.addAttribute("product2", product2);
		
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(product1);
		list.add(product2);
		
		model.addAttribute("list", list); // "list"라는 이름의 key로 list 담음
		
		return "list1"; 
		// forwarding 👉 자동으로 .html 확장자가 붙어서 templates 폴더로 찾아감
		// 아래 설정이 application.properties의 디폴트값이기 때문
		// spring.thymeleaf.prefix=classpath:/templates/
		// spring.thymeleaf.suffix=.html
	}
	
}

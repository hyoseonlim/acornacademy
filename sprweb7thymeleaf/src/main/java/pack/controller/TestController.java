package pack.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="thleaf")
public class TestController {
	
	@GetMapping("/ex1") // "thleaf/ex1" 요청을 받음
	public String abc1(Model model) {
		ItemDto dto = new ItemDto();
		dto.setId("ks1");
		dto.setName("마우스");
		dto.setRegDate(LocalDate.now());
		dto.setPrice(75000);
		model.addAttribute("dto", dto);
		return "show1"; // forward:show1
		// forwarding 👉 자동으로 .html 확장자가 붙어서 templates 폴더로 찾아감
		// 아래 설정이 application.properties의 디폴트값이기 때문
		// spring.thymeleaf.prefix=classpath:/templates/
		// spring.thymeleaf.suffix=.html
	}
	
	@GetMapping("/ex2") // "thleaf/ex2" 요청을 받음
	public ModelAndView abc2() {
		List<ItemDto> list = new ArrayList<ItemDto>();
		for(int i=1; i<=3; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("ks" + i);
			dto.setName("신상품(" + i + ")");
			dto.setPrice(1000 * i);
			dto.setRegDate(LocalDate.now());
			list.add(dto);
		}
		
		ModelAndView modelAndView = new ModelAndView("show2");
		modelAndView.addObject("dtos", list);
		
		return modelAndView;
	}
	
	@GetMapping("/ex3") // "thleaf/ex3" 요청을 받음
	public String abc3(Model model) {
		List<ItemDto> list = new ArrayList<ItemDto>();
		for(int i=1; i<=7; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("ks" + i);
			dto.setName("신상품(" + i + ")");
			dto.setRegDate(LocalDate.now());
			list.add(dto);
		}
		
		model.addAttribute("dtos", list);
		
		return "show3";
	}
	
	@GetMapping("/ex4") // "thleaf/ex4" 요청을 받음
	public String abc3(Model model, @RequestParam("param1") String param1, @RequestParam("param2") String param2) { // 파라미터 2개를 받아옴. Model을 파라미터 이후 순서로 받아도 됨
		//System.out.println(param1 + " " + param2);
		model.addAttribute("arg1", param1);
		model.addAttribute("arg2", param2);
		return "show4";
	}
	
	@GetMapping("/ex5")
	public String abc5(Model model) {
		return "show5";
	}
	
}

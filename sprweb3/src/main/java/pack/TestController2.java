package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test9") // 요청을 여기에 분리시켜두고
public class TestController2 {
	
	@RequestMapping(method=RequestMethod.GET) // 요청방식은 여기랑
	public String def1(Model model) {
		// HttpServletRequest 객체에 값을 저장 후 view에 전달
		model.addAttribute("msg","GET method 성공");
		return "list"; // forwarding
	}
	
	@RequestMapping(method=RequestMethod.POST) // 여기
	public String def2(Model model) {
		// HttpServletRequest 객체에 값을 저장 후 view에 전달
		model.addAttribute("msg","POST method 성공");
		return "list"; // forwarding
	}
	
}

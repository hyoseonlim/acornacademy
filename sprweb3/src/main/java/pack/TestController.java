package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

/*
@RestController // @Controller + @ResponseBody 
public class TestController {
	@RequestMapping("test1") // index.html 파일의 a 태그 내 요청명 (get/post 모두 가능)
	public String abc() {
		return "요청에 대한 반응 보이기";
	}
}
*/

@Controller 
public class TestController {
	@RequestMapping("test1") // get&post 모두 처리(Servlet의 service 메소드처럼). "test1": index.html 파일의 a 태그 내 요청명
	public ModelAndView abc1() {
		/*
		application.properties 파일에서 view의 prefix를 "/WEB-INF/views/"로, suffix를 ".jsp"로 설정했으므로
		"list"는 "/WEB-INF/views/list.jsp"가 된다!
		return new ModelAndView("list", "msg", "안녕? jsp"); // String viewName, String modelName, Object modelObject
		
		풀어적으면 아래와 같음
		*/
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		// request.setAttribute("msg", "안녕? jsp")을 ModelAndView의 addObject 메소드가 함
		// HTTPServletRequest를 사용해 key & value 로 jsp에 전송
		modelAndView.addObject("msg", "안녕? jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="test2", method=RequestMethod.GET) // get 요청만 처리하도록 설정. post 방식으로 요청 시 405 ERROR "Method 'POST' is not supported"
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "성공");
	}
	
	@GetMapping("test3") // get 요청 처리
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "성공");
	}
	
	@GetMapping("test4") // get 요청 처리
	public String abc4(Model model) { // Model이 곧 request (Spring에서는 HTTPServletRequest에 넣지 않고 Model에 넣음
		model.addAttribute("msg","성공");
		return "list"; // view 파일명 반환 (반환 타입이 string이지만, 파라미터로 Model 받는 경우 view 파일명으로 인식됨)
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST)
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "성공");
	}
	
	@PostMapping("test6") // post 요청 처리
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "성공");
	}
	
	@PostMapping("test7") // post 요청 처리
	public String abc7(Model model) {
		model.addAttribute("msg","성공");
		return "list";
	}
	
	@GetMapping("test8")
	@ResponseBody // String, Map, JSON 등을 그대로 반환
	public String abc8() { // Model이 곧 request (Spring에서는 HTTPServletRequest에 넣지 않고 Model에 넣음
		String value = "일반 데이터 (String, Map, JSON 등)을 전달 가능!";
		return value;
	}
	
	@GetMapping("test8_1")
	@ResponseBody
	public DataDto abc8_1() {
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("톰아저씨");
		return dto; // JSON 형태로
	}
}

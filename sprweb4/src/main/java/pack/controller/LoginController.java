package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	// log 정보 출력용 클래스
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); // 현재 클래스에 적용
	
	@GetMapping("login")
	public String submitCall() {
		// return "login.html"; // 이렇게 적으면 디폴트 설정값인 forward로, application.properties 파일에서 설정해둔대로 WEB-INF로 접근
		return "redirect:login.html"; // 그러므로 sendRedirect! "redirect:login.html"로 써도 됨
	}
	// jsp에서 context root인 webapp에 생성한 파일
	
	// ✏️ 클라이언트가 전달한 값 수신 방법 1: 전통적
	/*
	@PostMapping("login") // 다른 요청이지만 가독성을 위해 이름 일치시키기. 요청 방식이 다르기 때문에 같은 이름으로 쓸 수 있음
	public String submit(HttpServletRequest request, Model model) { // JSP로 내보내도록 Model 받음 (리턴타입이 ModelAndView가 아닌 String이므로 Model이 파라미터로 있어야만 함)
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// System.out.println(id + " " + pwd) 대신 아래처럼 맥락있게 😌
		logger.info(id + " " + pwd); // 로그정보와 같이 출력됨 (로그레벨 trace > debug > info > warn > error > fatal). 이후 배포 시 주석 처리
		
		String data = "로그인: ";
		if(id.equals("kor") && pwd.equals("111")) data += "성공";
		else data += "실패";
		
		model.addAttribute("data", data);
		
		return "result"; // WEB-INF/views/result.jsp에 접근하게 됨 (application.properties에서 한 설정에 의함)
	}
	*/
	
	// ✏️ 클라이언트가 전달한 값 수신 방법 2: Spring Annotation 사용
	@PostMapping("login")
	public String submit(@RequestParam(value="id") String id, @RequestParam(value="pwd", defaultValue="111") int pwd, Model model) {
		// HttpServletRequest 대신 @RequestParam 어노테이션을 사용
		// @RequestParam(value="a") String a; 는 String a = request.getParameter("a"); 와 같다.
		/*
		HttpServletRequest 사용할 때와 다른 점
		1. client로부터 받는 모든 데이터는 문자열 타입이지만, 어노테이션에 데이터를 받는 타입을 int로 쓰면 자동 형변환이 됨
		2. defaultValue로 초기치 부여 가능
		*/
		String data = "로그인: ";
		if(id.equals("kor") && pwd==111) data += "성공";
		else data += "실패";
		
		model.addAttribute("data", data);
		return "result";
	}

}	

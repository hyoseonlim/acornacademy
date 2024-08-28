package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.JwtService;

@Controller
@RequestMapping("/auth")
public class MyController {
	@Autowired
	private JwtService jwtService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "userid") String userid, 
                        @RequestParam(name = "password") String password,
                        HttpServletResponse response) {
        String validId = "hyo";
        String validPassword = "00";

        if (userid.equals(validId) && password.equals(validPassword)) {
            String token = jwtService.createToken(userid);
            Cookie cookie = new Cookie("jwt", token); // 클라이언트에 JWT 저장
            cookie.setHttpOnly(true); // 클라이언트에서 쿠키 수정 불가
            cookie.setPath("/"); // 쿠키 경로
            response.addCookie(cookie);
            return "redirect:/auth/success";
        } else {
            return "redirect:/auth/login?error";
        }
    }

    @GetMapping("/success")
    public String success(HttpServletRequest request, Model model) {
        String userid = getUserFromToken(request);
        if (userid == null) return "redirect:/auth/login";
        model.addAttribute("myuser", userid);
        return "success";  
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletResponse response) { // 클라이언트 컴퓨터의 쿠키 삭제
    	Cookie cookie = new Cookie("jwt", null); // JWT 쿠키를 무효화
    	cookie.setMaxAge(0);
        cookie.setPath("/"); // 쿠키 경로
        response.addCookie(cookie);
        return "redirect:/auth/login";
    }

    @GetMapping("/gugu")
    public String gugu(HttpServletRequest request) {
    	String userid = (String)getUserFromToken(request);
        if (userid == null) return "redirect:/auth/login";
        return "gugu";
    }
    
    @PostMapping("/gugu")
    public String gugu(@RequestParam(name="num") int num, HttpServletRequest request, Model model) {
    	String userid = getUserFromToken(request);
    	if (userid == null) return "redirect:/auth/login";
    	model.addAttribute("num", num);
        return "guguresult";
    }
    
    // 요청에서 JWT를 추출하고 사용자 Id 반환
    private String getUserFromToken(HttpServletRequest request) {
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null) {
    		for(Cookie cookie : cookies) {
    			if(cookie.getName().equals("jwt")) { // 쿠키 키가 jwt인 것 찾기
    				String token = cookie.getValue();
    				return jwtService.getUserFromToken(token);
    			}
    		}
    	}
    	return null;
    }
    
}

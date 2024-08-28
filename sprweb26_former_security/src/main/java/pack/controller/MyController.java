package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "userid", required = false) String userid, 
                        @RequestParam(name = "password", required = false) String password,
                        HttpSession session, Model model) {
        String validId = "hyo";
        String validPassword = "00";

        if (userid != null && password != null && userid.equals(validId) && password.equals(validPassword)) {
            session.setAttribute("user", userid);
            return "redirect:/success";
        } else if (userid != null && password != null) {
            model.addAttribute("error", "잘못된 아이디 또는 비밀번호입니다.");
            return "login";
        }

        // For GET request, just show the login page
        return "login";
    }

    @GetMapping("/success")
    public String success(HttpSession session, Model model) {
        String user = (String) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("myuser", user);
            return "success";
        } else {
            return "redirect:/login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	// session.invalidate(); 세션 전체를 지움
    	session.removeAttribute("user");
        return "redirect:/login";
    }

    @GetMapping("/gugu")
    public String gugu(HttpSession session) {
        return (session.getAttribute("user") != null) ? "gugu" : "redirect:/login";
    }
    
    @PostMapping("/auth/gugu")
    public String gugu(@RequestParam(name="num") int num, HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
            model.addAttribute("num", num);
            return "guguresult";
        } else {
            return "redirect:/login";
        }
    }
}

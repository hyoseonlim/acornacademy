package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDto;
import pack.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mservice; // 다형성을 위한 인터페이스
	
	@GetMapping("/member/mlist")
	public String memberlist(Model model) {
		mservice.getList(model); 
		// Model 객체에 List 객체 담아주는 void 메소드
		// Model 객체는 스프링이 관리하는 전역 객체이므로 반환할 필요 없음
		return "member/mlist";
	}
	
	@GetMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String insert(MemberDto bean) { // 원래 DTP가 아니라 Form Bean
		mservice.insert(bean);
		return "member/insert";
	}
	
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam(name = "num") Long num, Model model) {
		mservice.getData(num, model);
		return "member/updateform";
	}
	
	@PostMapping("/member/update")
	public String update(MemberDto bean) { // 원래 DTO가 아니라 Form Bean
		mservice.update1(bean);
		return "member/update";
	}
	
	@GetMapping("/member/delete")
	public String delete(@RequestParam(name = "num") Long num, Model model) {
		mservice.delete(num);
		return "redirect:/member/mlist";
	}
	
}

package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.MemberDao;

@Controller
public class InsertController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("insert")
	public String insertForm(Model model) {
		return "insform"; 
	}
	
	@PostMapping("insert")
	public String insertProcess(MemberBean bean) { // MemberBean이 자동으로 어쩌구
		memberDao.insData(bean);
		return "redirect:/list"; // 클라이언트를 거쳐야 *추가 후* 목록 보기 가능
	}
	
}

package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class UpdateController {
	
	@Autowired
	MemberDao memdao;
	
	@GetMapping("update")
	public String updateForm(@RequestParam("id") String id, Model model) {
		MemberDto dto = memdao.getMember(id);
		model.addAttribute("mem", dto);
		return "upform";
	}
	
	@PostMapping("update")
	public String updateMember(MemberBean bean, Model model) {
		memdao.upData(bean);
		model.addAttribute("member", memdao.getMember(bean.getId()));
		return "detail";
	}
}

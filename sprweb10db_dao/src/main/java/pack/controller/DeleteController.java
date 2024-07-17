package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class DeleteController {

	@Autowired
	MemberDao dao;
	
	@GetMapping("delete")
	public String deleteMember(@RequestParam("id") String id, Model model) {
		dao.delData(id);
		List<MemberDto> list = dao.getMemberList();
		model.addAttribute("list",list);
		return "list";
	}
}

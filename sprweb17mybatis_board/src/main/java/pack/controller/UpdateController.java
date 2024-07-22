package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BoardDao;

@Controller
public class UpdateController {
	
	@Autowired
	BoardDao dao;
	
	@PostMapping("update")
	public String updateData(BoardBean bean, Model model) {
		model.addAttribute("board",bean);
		return dao.update(bean) ? "redirect:/list" : "err";
	}
}

package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BoardDao;

@Controller
public class DeleteController {
	
	@Autowired
	BoardDao dao;
	
	@GetMapping("delete")
	public String deleteData(BoardBean bean, Model model) {
		model.addAttribute("board",bean);
		return dao.delete(bean) ? "redirect:/list" : "err";
	}
}

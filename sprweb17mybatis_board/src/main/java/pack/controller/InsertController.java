package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BoardDao;

@Controller
public class InsertController {
	
	@Autowired
	BoardDao dao;
	
	@GetMapping("insert")
	public String insertForm() {
		return "insform";
	}
	
	@PostMapping("insert")
	public String insert(BoardBean bean) {
		return dao.insert(bean) ? "redirect:/list" : "err";
	}
}

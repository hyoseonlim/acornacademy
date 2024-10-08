package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String insert(BoardBean bean, Model model) {
		String result = dao.insertData(bean);
		if(result.equals("success")) {
			return "redirect:/list";
		} else {
			model.addAttribute("msg",result);
			return "err";
		}
	}
}

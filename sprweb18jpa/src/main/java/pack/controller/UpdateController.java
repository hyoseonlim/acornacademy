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
		String result = dao.updateData(bean);
		if(result.equals("success")) {
			return "redirect:/list"; // model에 list 유지중?
		} else {
			model.addAttribute("msg",result);
			return "err";
		}
	}

}
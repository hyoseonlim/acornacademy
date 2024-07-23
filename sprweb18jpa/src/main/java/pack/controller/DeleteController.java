package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDao;

@Controller
public class DeleteController {
	
	@Autowired
	BoardDao dao;
	
	@GetMapping("delete")
	public String deleteData(@RequestParam("num") int num, Model model) {
		String result = dao.deleteData(num);
		if(result.equals("success")) {
			return "redirect:/list";
		} else {
			model.addAttribute("msg",result);
			return "err";
		}
	}
}

package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class JikwonController {
	
	@GetMapping("/")
	public String start() {
		return "index"; // static 폴더가 아닌 곳(templates)에서 시작되도록 함
	}
	
	@Autowired
	DataDao dao;
	
	@GetMapping("showjikwon")
	public String searchJikwon(@RequestParam("jik") String jik, Model model) {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dao.getJikwonByJik(jik);
		model.addAttribute("jik",jik);
		model.addAttribute("datas",list);
		return "show";
	}
	
}

package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.DataDao;
import pack.model.Sangpum;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@Autowired
	DataDao dao; // Persistence 영역을 포함관계로
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("testjpa")
	public String list(Model model) {
		ArrayList<Sangpum> list = (ArrayList<Sangpum>)dao.getDataAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("search")
	public String search(FormBean bean, Model model) { // parameter나 form bean으로 searchValue 받을 수 있음
		ArrayList<Sangpum> list = (ArrayList<Sangpum>)dao.getDataSearch(bean.getSearchValue());
		model.addAttribute("list", list);
		return "list";
	}	
}

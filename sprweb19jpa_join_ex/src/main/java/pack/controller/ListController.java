package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.service.GogekService;
import pack.service.JikwonService;

@Controller
public class ListController {
	
	@Autowired
	private JikwonService jikwonservice;
	
	@Autowired
	private GogekService gogekservice;
	
	@GetMapping("/")
	public String jlist(Model model) {
		jikwonservice.getList(model);
		return "jlist";		
	}
	
	@GetMapping("/glist")
	public String glist(@RequestParam("no") int no, Model model) {
		gogekservice.getList(no, model);
		return "glist";		
	}
}

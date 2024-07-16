package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class JikwonController {
	@Autowired
	private DataDao dataDao;
	
	/*
	@GetMapping("showjikwon")
	public String listProcess(HttpServletRequest request, Model model) {
		String jik = request.getParameter("jik");
		ArrayList<JikwonDto> list = dataDao.selectJikwon(jik);
		model.addAttribute("datas",list);
		model.addAttribute("jik",jik);
		return "show";
	}
	*/
	
	// request 말고 @Requestparam이 있자나!!!!!!!!
	@GetMapping("showjikwon")
	public String listProcess(@RequestParam(value="jik") String jik, Model model) {
		ArrayList<JikwonDto> list = dataDao.selectJikwon(jik);
		model.addAttribute("datas",list);
		model.addAttribute("jik",jik);
		return "show";
	}
}

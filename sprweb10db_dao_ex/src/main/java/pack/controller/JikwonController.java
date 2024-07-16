package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.JikwonDao;
import pack.model.JikwonDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JikwonController {
	@Autowired
	private JikwonDao jikwonDao;
	
	@GetMapping("showjikwon")
	public String getMethodName(@RequestParam(value="jik") String jik, Model model) {
		ArrayList<JikwonDto> list = (ArrayList)jikwonDao.getJikwonList(jik);
		model.addAttribute("datas",list);
		model.addAttribute("jik",jik);
		return "show";
	}
	
}

package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.Mem;

@Controller
public class MemController {

	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping({"/", "start"})
	public String start() {
		return "start";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<Mem> list = (ArrayList<Mem>)dataProcess.getAllData();
		model.addAttribute("datas",list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insertForm() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insert(MemBean bean, Model model) {
		return dataProcess.insert(bean) ? "redirect:/list" : "error";
	}
	
	@GetMapping("update")
	public String updateForm(@RequestParam("num") int num, Model model) {
		Mem mem = dataProcess.getOneData(num);
		model.addAttribute("mem", mem);
		return "update";
	}
	
	@PostMapping("update")
	public String update(MemBean bean) {
		return dataProcess.update(bean) ? "redirect:/list" : "redirect:/error";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") int num, Model model) {
		return dataProcess.delete(num) ? "redirect:/list" : "redirect:/error";
	}
	
	@GetMapping("error")
	public String error() {
		return "error";
	}
	
}

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FormController {
	@GetMapping("show")
	public String printInfo(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
		int ageG = age / 10 * 10;
		model.addAttribute("name", name);
		model.addAttribute("ageG", ageG);
		return "result";
	}	
}

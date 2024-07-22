package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.Board;
import pack.model.BoardDao;

@Controller
public class ListController {

	@Autowired
	private BoardDao dao;
	
	@RequestMapping(value="list", method=RequestMethod.GET) // get, post 구분 안 함
	public String list(Model model){
		ArrayList<Board> list = (ArrayList<Board>)dao.all();
		model.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping("update")
	public String updateForm(Model model){
		ArrayList<Board> list = (ArrayList<Board>)dao.all();
		model.addAttribute("list",list);
		return "list";
	}
}

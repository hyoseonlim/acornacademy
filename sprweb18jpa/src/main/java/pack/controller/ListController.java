package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.Board;
import pack.model.BoardDao;

@Controller
public class ListController {

	@Autowired
	BoardDao dao;
	
	//@RequestMapping(value="list", method=RequestMethod.GET)
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<Board> list = (ArrayList<Board>)dao.all();
		model.addAttribute("list",list);
		return "list";
	}
	
	@PostMapping("search")
	public String search(BoardBean bean, Model model) {
		List<Board> list = null;
		String option = bean.getSearchOption();
		String keyword = bean.getSearchValue();
		list = option.equals("author") ? dao.getByAuthor(keyword) : dao.getByTitle(keyword);
		model.addAttribute("list",(ArrayList<Board>)list);
		return "list";
	}	
}

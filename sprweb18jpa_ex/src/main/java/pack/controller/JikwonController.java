package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.Jikwon;
import pack.model.JikwonDao;

@Controller
public class JikwonController {
	
	@Autowired
	JikwonDao dao;
	
	@PostMapping("show")
	public String list(FormBean bean, Model model) {
		List<Jikwon> list;
		int buser = Integer.parseInt(bean.getChosenBuser());
		String rating = bean.getChosenRating();
		
		list = rating.equals("all") ? dao.selectAll(buser) : dao.selectByRating(buser, rating);
		int avg = dao.calcAvgPay(list);
		
		model.addAttribute("list", (ArrayList<Jikwon>)list);
		model.addAttribute("buserName", dao.selectBuserName(buser));
		model.addAttribute("avg", avg);
		return "show";
	}
	
}

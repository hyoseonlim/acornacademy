package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/")
	public String showStartPage() {
		return "start";
	}
	
	@Autowired
	private FriendService service;
	
	@GetMapping("/list")
	public String showList(Model model) {
		List<Friend> friends = service.getAll();
		model.addAttribute("friends",friends);
		return "list";
	}
}
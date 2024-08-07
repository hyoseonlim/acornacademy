package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.JikwonDto;
import pack.service.JikwonService;

@RestController
@CrossOrigin(origins = "*") // 모든 출처의 요청을 허용
public class JikwonController {
	@Autowired
	private JikwonService service;
	
	@GetMapping("jikwon/{keyword}")
	public List<JikwonDto> list(@PathVariable("keyword") String keyword){
		return service.getList(keyword);
	}
}

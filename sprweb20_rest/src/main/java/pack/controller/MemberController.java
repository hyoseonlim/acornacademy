package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.MemberDto;
import pack.repository.MemberDao;


//@Controller
//@ResponseBody
// 둘을 합한 게 
@RestController
// 비동기처리에서 사용. 객체 데이터를 JSON 형태로 변환해 반환하는 역할
// RESTful한 프로그램을 위함
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	@GetMapping("/members") // 전체자료읽기
	public List<MemberDto> list() { 
		//  JSON 형태로 변환해 클라이언트에 반환(JavaScript AJAX 요청)
		// (기존처럼 HTML 파일로 변환하는 것이 아님)
		System.out.println("get 요청 했넹 (o゜▽゜)o☆");
		return dao.getList();
	}
	
	@PostMapping("/members") // 추가
	public Map<String, Object> insert(@RequestBody MemberDto dto) {
		// @RequestBody: 요청 본문에 담긴 값을 자바객체로 변환
		dao.insert(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true); // put(String key, Object value)
		return map;
	}
	
	//@GetMapping("/{members}/{num}" 이렇게 두 개도 받을 수 있어
	@GetMapping("/members/{num}") // 자료 1개 읽기 http://localhost:80/members/3
	public MemberDto one(@PathVariable("num") int num) {
		return dao.getData(num);
	}
	
	@PutMapping("/members/{num}") // 자료 수정
	public Map<String, Object> update(@PathVariable("num") int num, @RequestBody MemberDto dto) {
		dao.update(dto);
		/*
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSucceess", true);
		return map;
		이 세 줄을 아래 한 줄로 작성 가능하다 (❁´◡`❁)
		*/
		return Map.of("isSuccess", true);
	}
	
	@DeleteMapping("/members/{num}")
	public Map<String, Object> delete(@PathVariable("num") int num) {
		dao.delete(num);
		return Map.of("isSuccess", true);
	}
	
	/*
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<MemberDto> list = dao.getList();
		model.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping("/insertform")
	public String insertform() {
		return "insertform";
	}
	
	@PostMapping("/insert")
	public String insert(MemberDto dto) {
		dao.insert(dto);
		return "redirect:/members"; // 요청명!!!!!! 추가 후 목록보기
	}
	*/
}

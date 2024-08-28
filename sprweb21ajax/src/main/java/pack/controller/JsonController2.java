package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController2 {
	
	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJsons() { // 복수를 반환할 땐 Map<Key, Value>
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "공기밥");
		data.put("age", "23");
		dataList.add(data);
	
		data = new HashMap<String, String>();
		data.put("name", "주먹밥");
		data.put("age", "35");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "비빔밥");
		data.put("age", "17");
		dataList.add(data);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("datas", dataList); // Map을 담는 List 객체를 Map이 "datas"라는 key의 value로 담기
		// @ResponseBody에 의해 JSON의 모양을 띄는 문자열로 전달됨
		
		return dataMap;
	}
	
}

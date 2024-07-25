package pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pack.dto.JikwonDto;
import pack.repository.JikwonRepository;

@Service
public class JikwonService {
	
	@Autowired
	private JikwonRepository repo;
	
	public void getList(Model model) {
		/*
		List<Jikwon> entityList = repo.findAll();
		List<JikwonDto> dtoList = new ArrayList<JikwonDto>();
		for(Jikwon entity : entityList) {
			dtoList.add(JikwonDto.toDto(entity));
		}
		map() 메소드를 사용하면 아래처럼 가능
		*/
		
		List<JikwonDto> dtoList = repo.findAll()
									.stream()
									.map(JikwonDto::toDto)
									.toList();
		
		model.addAttribute("list", dtoList);
	}
	
	public void getOne(Model model) {
		//Jikwon jikwon = repo.findById(null)
		model.addAttribute("jikwon", repo.findAll());
	}
}

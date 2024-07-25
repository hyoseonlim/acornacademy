package pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pack.dto.GogekDto;
import pack.entity.Jikwon;
import pack.repository.JikwonRepository;

@Service
public class GogekService {
	
	@Autowired
	JikwonRepository jikwonRepo;
	
	public void getList(int no, Model model) {
		Jikwon jikwon = jikwonRepo.findById(no).get();
		
		/*
		List<Gogek> entityList = jikwon.getGlist(); // Gogek 엔티티에 join으로 만든 해당 Gogek 리스트
		List<GogekDto> dtoList = new ArrayList<GogekDto>(); // List는 인터페이스라 new가 안됨
		for(Gogek entity : entityList) {
			dtoList.add(GogekDto.toDto(entity));
		}
		map() 메소드를 사용하면 아래처럼 가능
		*/
		
		List<GogekDto> dtoList = jikwon.getGlist()
									.stream()
									.map(GogekDto::toDto)
									.toList();

		model.addAttribute("jikwon",jikwon);
		model.addAttribute("list",dtoList);
	}
}

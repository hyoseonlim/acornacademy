package pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.dto.JikwonDto;
import pack.repository.JikwonRepository;

@Service
public class JikwonService {
	
	@Autowired
	private JikwonRepository repo;
	
	public List<JikwonDto> getList(String jik){
		List<JikwonDto> list = repo.findByJik(jik).stream().map(JikwonDto::toDto).toList();
		return list;
	}
	
}

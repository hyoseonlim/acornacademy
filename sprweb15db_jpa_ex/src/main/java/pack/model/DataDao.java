package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	
	@Autowired
	JikwonRepository repository;
	
	public List<Jikwon> getJikwonByJik(String jik){
		List<Jikwon> list = repository.findByJik(jik);
		return list;
	}

}

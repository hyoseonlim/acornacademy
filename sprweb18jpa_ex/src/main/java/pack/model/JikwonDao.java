package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao {
	
	@Autowired
	DataRepository repository;
	
	public List<Jikwon> selectAll(int buser){
		List<Jikwon> list = repository.findByBuser(buser);
		return list;
	}
	
	public List<Jikwon> selectByRating(int buser, String rating){
		List<Jikwon> list = repository.findByBuserAndRating(buser, rating);
		return list;
	}
	
	public String selectBuserName(int buser) {
		return repository.findBuserName(buser);
	}
	
	public int calcAvgPay(List<Jikwon> list) {
		int total = 0;
		for(Jikwon j : list) {
			total += j.getPay();
		}
		return total/list.size();
	}

}

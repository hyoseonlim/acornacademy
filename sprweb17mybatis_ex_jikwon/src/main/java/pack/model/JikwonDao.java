package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.FormBean;

@Repository
public class JikwonDao {

	@Autowired
	DataMapInterface mapper;
	
	public List<Jikwon> selectAll(String chosenBuser){
		List<Jikwon> list = mapper.selectAll(chosenBuser);
		return list;
	}
	
	public List<Jikwon> selectByRating(FormBean bean){
		List<Jikwon> list = mapper.selectByRating(bean);
		return list;
	}
	
	public int calcAvgPay(List<Jikwon> list) {
		int total = 0;
		for(Jikwon j : list) {
			total += j.getJikwon_pay();
		}
		return total/list.size();
	}
	
}

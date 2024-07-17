package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

	@Autowired
	private DataMappingInter dataMappingInter;
	
	public List<JikwonDto> getJikwonByJik(String jik){
		List<JikwonDto> list = dataMappingInter.selectJikwon(jik);
		return list;
	}
}

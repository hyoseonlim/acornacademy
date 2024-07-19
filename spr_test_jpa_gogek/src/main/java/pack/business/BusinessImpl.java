package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.GogekDto;

@Service
public class BusinessImpl {
	@Autowired
	private DataInterface dataInterface;

	public void dataPrint() {
		List<GogekDto> glist = dataInterface.selectDataAll();
		for(GogekDto gogek : glist) {
			System.out.println(gogek.getNo() + " " + gogek.getName() + " " + gogek.getTel());
		}	
	}
}

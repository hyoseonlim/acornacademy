package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataImpl;
import pack.model.DataInter;
import pack.model.JikwonDto;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	private DataInter dataInterface;
	
	public void printJikwon() {
		// 전체 직원 정보
		List<JikwonDto> jlist = dataInterface.selectAllJikwon();		
		System.out.println("🐻‍❄️ 직원 정보 🐻");
		for(JikwonDto j : jlist) {
			System.out.println(j.getJikwon_no() + " " + j.getJikwon_name() + " " + j.getBuser_num() + " " + j.getJikwon_ibsail());
		}
	}
	
	public void printJikwonCntByBuser() {
		// 부서별 인원 수
		List<Object[]> result = dataInterface.selectCount();
		System.out.println("\n🐧 부서별 인원수 🐵");
		
		// List 객체인 result에 담긴 Object[]에서 0번째 인덱스인 부서번호, 1번째 인덱스인 직원 수를 출력
		for(Object[] objArray : result) {
			String buserNum = (String)objArray[0];
			Long cntJikwon = (Long)objArray[1];
			System.out.println(buserNum + "번 부서: " + cntJikwon + "명");
		}
	}
}

package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter{
	// model 클래스를 포함관계로 호출
	@Autowired
	private JikwonInter inter; 
	
	@Override
	public void showAllJikwon() {
		List<JikwonDto> list = inter.selectAllJ();
		System.out.println("🐻‍❄️직원 자료🐻‍❄️");
		System.out.println("사번 이름 부서명 입사년");
		for(JikwonDto s:list) {
			// 이쁘게 출력되게,,
			if(Integer.parseInt(s.getJikwon_no()) < 10) s.setJikwon_no("0" + s.getJikwon_no());
			if(s.getJikwon_name().length() == 2) s.setJikwon_name(s.getJikwon_name() + " ");
			
			if(s.getBuser_name()==null) s.setBuser_name("무소속");
			System.out.println(s.getJikwon_no() + " " + s.getJikwon_name() + " " +
		s.getBuser_name() + " " + s.getJikwon_ibsail());
		}
	}
	
	@Override
	public void showJikwonByBuser() {
		List<JikwonDto> list = inter.selectJByBuser();
		System.out.println("\n🐵부서별 인원수🐵");
		for(JikwonDto s:list) {
			System.out.println(s.getBuser_name() + "  " + s.getJikwon_ppl());
		}
	}
	
	@Override
	public void showRichJikwon() {
		List<JikwonDto> list = inter.selectRichJ();
		System.out.println("\n🐧부서별 최대 급여자🐧");
		for(JikwonDto s:list) {
			System.out.println(s.getBuser_name() + ": " + s.getJikwon_name() + "(" + s.getJikwon_pay() + ")");
		}
	}
}

package pack.model;

import java.util.List;

public interface JikwonInter {
	List<JikwonDto> selectAllJ(); // 전체 직원 자료
	List<JikwonDto> selectJByBuser(); // 부서별 인원수
	List<JikwonDto> selectRichJ(); // 부서별 최대 급여자
}

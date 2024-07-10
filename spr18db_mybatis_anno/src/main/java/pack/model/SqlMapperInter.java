package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	
	// 전체 직원 자료
	@Select("select jikwon_no, jikwon_name, buser_name, year(jikwon_ibsail) as jikwon_ibsail "
			+ "from jikwon left outer join buser on buser_num = buser_no")
	List<JikwonDto> selectAllJikwon();
	
	// 부서별 인원수
	@Select("select buser_name, count(*) as jikwon_ppl from jikwon right outer join buser "
			+ "on buser_num = buser_no group by buser_no")
	List<JikwonDto> selectJikwonByBuser();
	
	// 부서별 최대 급여자
	@Select("select buser_name, jikwon_name, jikwon_pay from jikwon inner join buser on buser_num = buser_no "
			+ "where (buser_num, jikwon_pay) in (select buser_num, max(jikwon_pay) from jikwon group by buser_num);")
	List<JikwonDto> selectRichJikwon();
}

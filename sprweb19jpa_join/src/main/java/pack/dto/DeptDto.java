package pack.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Dept;
import pack.entity.Emp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDto { 
	private int deptno;
	private String dname;
	private String loc;

	private int count; // 근무 인원수 저장용
	private List<String> names; // 근무 직원의 이름들
	
	// Entity ➡️ Dto
	public static DeptDto toDto(Dept dept) {
		// 직원명 저장 리스트
		List<String> names = new ArrayList<String>();
		for(Emp temp:dept.getList()) {
			names.add(temp.getEname());
		}
		
		// 롬복 Builder로 선택적으로 생성자 주입 값을 입력 가능: chain 사용
		return DeptDto.builder()
				.deptno(dept.getDeptno())
				.dname(dept.getDname())
				.loc(dept.getLoc())
				.count(dept.getList().size())
				.names(names)
				.build();
	}
}
package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dept { // @Table 어노테이션 없으므로 DEPT 이름 그대로 생성될 것
	@Id
	private int deptno;
	private String dname;
	private String loc;
	
	/* 
	✔️ FetchType.LAZY 지연 로딩
	⭐ Dept 사용 중 Emp는 필요 시에만 로딩
	⭐ 세션이 열려있는 동안 세션 관리가 필요
	⭐ LazyInitializationException 발생 가능
	
	✔️ FetchType.EAGER 즉시 로딩
	⭐ 필요 여부 관련없이 바로 로딩하므로 관리 편리
	⭐ 메모리 낭비 발생
	*/
	@OneToMany(mappedBy="dept", fetch=FetchType.EAGER)
	@Builder.Default // Emp 엔티티 생성 시 list 초기화
	private List<Emp> list = new ArrayList<Emp>();
}

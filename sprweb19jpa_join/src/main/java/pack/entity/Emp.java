package pack.entity;

import java.util.Date;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Emp { // @Table 어노테이션 없으므로 DEPT 이름 그대로 생성될 것
	@Id
	private Integer empno; // 기본형 int는 디폴트 0이므로 참조형 Integer로 해야 NULL 가능
	
	@Temporal(TemporalType.DATE) // JPA에서 날짜 타입 매핑 시 사용
	private Date hiredate; 
	
	private String ename;
	private String job; 
	private Double sal; // salary
	private Integer mgr; // 관리자 직원번호
	private Double comm; // commission
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="deptno", foreignKey=@ForeignKey(value=ConstraintMode.NO_CONSTRAINT))
	private Dept dept;
	// FK 제약조건 비활성화 -> 없는 번호 넣어도 ok. 에러 발생 안 함
}

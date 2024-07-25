package pack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Gogek {
	@Id
	@Column(name = "gogek_no")
	private int no;
	
	@Column(name = "gogek_name")
	private String name;
	
	@Column(name = "gogek_jumin")
	private String jumin;
	
	@Column(name = "gogek_tel")
	private String tel;
	
	@ManyToOne
	@JoinColumn(name = "gogek_damsano") // 실제 테이블의 조인 컬럼명을 적는다.
	private Jikwon jikwon;
}

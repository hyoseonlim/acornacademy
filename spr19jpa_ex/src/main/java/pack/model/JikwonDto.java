package pack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="jikwon") // 물리적인 테이블
public class JikwonDto { // JPA에서 논리적인 테이블로 사용됨
	@Id
	private String jikwon_no;
	
	private String buser_num;
	private String jikwon_name, jikwon_ibsail;
}

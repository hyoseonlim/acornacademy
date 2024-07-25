package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Jikwon {
	@Id
	@Column(name = "jikwon_no")
	private int no;
	
	@Column(name = "jikwon_name")
	private String name;
	
	@Column(name = "jikwon_jik")
	private String jik;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="buser_num") // 실제 DB 테이블의 조인할 컬럼명
	private Buser buser;
	
	@OneToMany(mappedBy="jikwon") // Gogek 엔티티의 jikwon 필드를 통해 glist를 매핑
	@Builder.Default
	private List<Gogek> glist = new ArrayList<Gogek>();
}

package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Jikwon {
	@Id
	@Column(name = "jikwon_no")
	private int no;
	
	@Column(name = "jikwon_name")
	private String name;
	
	@Column(name = "jikwon_jik")
	private String jik;
	
	@Column(name = "jikwon_pay")
	private int pay;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="buser_num")
	private Buser buser;
}

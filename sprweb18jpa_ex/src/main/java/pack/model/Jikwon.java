package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class Jikwon {
	@Id
	@Column(name = "jikwon_no")
	int no;
	
	@Column(name = "jikwon_name")
	String name;
	
	@Column(name = "jikwon_jik")
	String jik;
	
	@Column(name = "jikwon_rating")
	String rating;
	
	@Column(name = "buser_num")
	int buser;
	
	@Column(name = "jikwon_pay")
	int pay;
}

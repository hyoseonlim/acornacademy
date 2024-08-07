package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Buser {
	@Id
	@Column(name = "buser_no")
	private int no;
	
	@Column(name="buser_name")
	private String name;
}

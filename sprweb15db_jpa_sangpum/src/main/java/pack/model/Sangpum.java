package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="sangdata")
public class Sangpum {
	@Id
	private int code;
	
	@Column(nullable = false)
	private String sang;
	
	private int su;
	private int dan;
}

// 원본테이블의 모든 컬럼을 작성할 필요 없고, 없는 컬럼 작성도 가능

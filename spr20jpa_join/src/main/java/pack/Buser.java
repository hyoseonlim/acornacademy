package pack;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "buser") // (테이블명과 클래스명의 이름이 같으니 name 설정 불필요
public class Buser {
	@Id
	@Column(name="buser_no")
	private int buserNo;
	
	@Column(name="buser_name")
	private String buserName;
}

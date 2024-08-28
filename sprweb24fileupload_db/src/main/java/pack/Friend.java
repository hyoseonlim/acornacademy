package pack;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Friend {
	@Id // @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment로 설정된 칼럼에 사용
	private int bunho;
	
	private String irum;
	private String junhwa;
	private String jikup;
	private String imagetype;
	
	@Lob // BLOB, CLOB 타입으로 처리
	private byte[] sajin;
	
	// DB와 관련 없는 임시 데이터 저장용
	@Transient
	private String base64Image; // base64로 인코딩된 이미지 타입
}

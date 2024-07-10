package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data // = @Getter & @Setter & @NoArgsConstructor
@AllArgsConstructor
@Builder // Builder Pattern 사용 이유: 생성자의 단점 해결 (https://mangkyu.tistory.com/163)
public class SangpumDto {
	private String code, sang, su, dan;	
}
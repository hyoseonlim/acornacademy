package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.Jikwon;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JikwonDto {
	private int no;
	private String name;
	private String busername;
	private String jik;
	private int pay;
	
	public static JikwonDto toDto(Jikwon entity) {
		
		return JikwonDto.builder()
				.no(entity.getNo())
				.name(entity.getName())
				.busername(entity.getBuser().getName()) // 부서 엔티티에서 이름 가져오기
				.jik(entity.getJik())
				.pay(entity.getPay())
				.build();
	}
}


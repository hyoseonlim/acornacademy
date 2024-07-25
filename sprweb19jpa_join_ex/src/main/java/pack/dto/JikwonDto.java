package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Jikwon;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JikwonDto {
	private int no;
	private String name;
	private String jik;
	private String busername;
	private String checkgogek;
	
	public static JikwonDto toDto(Jikwon entity) {
		
		return JikwonDto.builder()
				.no(entity.getNo())
				.name(entity.getName())
				.jik(entity.getJik())
				.busername(entity.getBuser().getName()) // 부서 엔티티에서 이름 가져오기
				.checkgogek(entity.getGlist().size()>0 ? "0" : "X")
				.build();
	}
}
